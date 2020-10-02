"""
Target scanning
- Nslookup - DNS Scanning
- Nmap
- Dirb

Methodologies
- Open source security testing methodology manual (OSSTMM)
- Open web application security project (OWASP)
- Penetration testing execution standard (PTES)
- NIST 800-115

PTES
1.- Pre-engagement interactions
2.- Intelligence gathering
3.- Thread modeling
5.- Vulnerability analysis
6.- Exploitation
7.- Post exploitation
8.- Reporting
"""

# Python nmap scanner
# Determine fingerprint OS
# Scratch the ping ttl and traceroute hops to determine OS

import nmap
import time


def scanner(target, port=80):
  nm_scan = nmap.PortScanner()
  print('\nRunning....\n')
  nm_scanner = nm_scan.scan(target, str(port), arguments='-O')
  scan_result = "Ok!"
  try:
    host_is_up = 'The host is: ' + nm_scanner['scan'][target]['status']['state']
    port_open = 'The port 80 is: ' + nm_scanner['scan'][target]['tcp'][port][
      'state']
    method_scan = 'Scanning method: ' + nm_scanner['scan'][target]['tcp'][port][
      'reason']
    guess_os = "There is %s percent chance that the host is running %s" % (
      nm_scanner['scan'][target]['osmatch'][0]['accuracy'],
      nm_scanner['scan'][target]['osmatch'][0]['name']
    )
  except Exception:
    host_is_up = 'The host is unknown'
    port_open = 'The port 80 is unknown'
    method_scan = 'Scanning method is unknown'
    guess_os = 'Host OS is unknown'
    scan_result = 'Error'
    pass

  timestamp = time.strftime("%Y-%m-%d_%H:%M:%S GMT", time.gmtime())

  with open("output/%s.txt"%target, 'w') as f:
    f.write(f'{host_is_up}\n{port_open}\n{method_scan}\n{guess_os}')
    f.write(f'\nReport generated {timestamp}')
    f.write(f'\nReport status {scan_result}')

  print('\nFinished!!! 🍻\n')
