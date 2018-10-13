# Demo

In this demo application we retrieve contact name, phone number, email, etc. information by getting contacts list programmatically.

## ContactsContract 

ContactsContract defines an extensible database of contact-related information. Contact information is stored in a three-tier data model:
* A row in the ContactsContract.Data table can store any kind of personal data, such as a phone number or email addresses. The set of data kinds that can be stored in this table is open-ended. There is a predefined set of common kinds, but any application can add its own data kinds.
* A row in the ContactsContract.RawContacts table represents a set of data describing a person and associated with a single account (for example, one of the user's Gmail accounts).
* A row in the ContactsContract.Contacts table represents an aggregate of one or more RawContacts presumably describing the same person. When data in or associated with the RawContacts table is changed, the affected aggregate contacts are updated as necessary. 

## Additional Resources

[Contacts Provider](https://developer.android.com/guide/topics/providers/contacts-provider)
[Retrieve a list of contacts](https://developer.android.com/training/contacts-provider/retrieve-names)
