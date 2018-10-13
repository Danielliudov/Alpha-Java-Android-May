# Slack Application

Create slack-like console application according to the following requirements.

Application has many **channels** and one of them is the **current** channel. Channels have **name** which should be unique.

Application supports the following operations:
- Create new channel.
- Switch current channel.
- Post message in current channel.
- Like message (by timestamp).
- Download message (by timestamp).
- List channel history.
- Clear channel history.

There are four different types of messages:
- Text message
- Image message
- Icon message
- File message

All messages have **author** and **timestamp** and can be identified by the **timestamp**.

Text message has text field.
Image message has image name field.
Icon message has icon type filed.
File message has file name field.

**Text** and **Image** messages support like operation. When someone likes a message log in the console who liked it. When showing message show how many likes it has.

**Image** and **File** messages support download operation. When someone downloads a message log in the console the activity.