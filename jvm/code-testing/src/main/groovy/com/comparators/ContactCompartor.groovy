package com.comparators

import com.models.Contact

class ContactCompartor implements Comparator<Contact> {

    @Override
    int compare(Contact contact, Contact t1) {
        return contact.email == t1.email ? 0 : -1
    }
}
