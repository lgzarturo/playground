import json
from dateutil import parser


class ActivityList:
	def __init__(self, activities):
		self.activities = activities

	def _get_data_from_json(self, data):
		entry_list = []
		for activity in data['activities']:
			entry_list.append(
				Activity(
					name=activity['name'],
					time_entries=self._get_time_entries(activity)
				)
			)
		self.activities = entry_list
		return entry_list

	def _get_time_entries(self, data):
		entry_list = []
		for entry in data['time_entries']:
			entry_list.append(
				TimeEntry(
					start_time=parser.parse(entry['start_time']),
					end_time=parser.parse(entry['end_time']),
					days=entry['days'],
					hours=entry['hours'],
					minutes=entry['minutes'],
					seconds=entry['seconds'],
				)
			)
		self.time_entries = entry_list
		return entry_list

	def initialize(self):
		activity_list = ActivityList([])
		with open('activities.json', 'r') as f:
			data = json.load(f)
			activity_list = ActivityList(
				activities=self._get_data_from_json(data)
			)
		return activity_list

	def _get_activities_to_json(self):
		entry_list = []
		for activity in self.activities:
			entry_list.append(activity.serialize())
		return entry_list

	def serialize(self):
		return {
			'activities': self._get_activities_to_json()
		}


class Activity:
	def __init__(self, name, time_entries):
		self.name = name
		self.time_entries = time_entries

	def _get_entries_to_json(self):
		entry_list = []
		for time in self.time_entries:
			entry_list.append(time.serialize())
		return entry_list

	def serialize(self):
		return {
			'name': self.name,
			'time_entries': self._get_entries_to_json()
		}


class TimeEntry:
	def __init__(self, start_time, end_time, days, hours, minutes, seconds):
		self.start_time = start_time
		self.end_time = end_time
		self.total_time = end_time - start_time
		self.days = days
		self.hours = hours
		self.minutes = minutes
		self.seconds = seconds
		self.initialize()

	def initialize(self):
		self.days = self.total_time.days
		self.seconds = self.total_time.seconds
		self.hours = 0 if self.days == 0 else self.days * 24 + self.seconds
		self.minutes = self.seconds % 3600
		self.seconds = self.seconds % 60

	def serialize(self):
		return {
			'start_time': self.start_time.strftime("%Y-%m-%d %H:%M:%S"),
			'end_time': self.end_time.strftime("%Y-%m-%d %H:%M:%S"),
			'days': self.days,
			'hours': self.hours,
			'minutes': self.minutes,
			'seconds': self.seconds,
		}

