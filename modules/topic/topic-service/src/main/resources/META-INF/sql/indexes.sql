create index IX_6F42529 on Conversation_Message (topicId);
create index IX_29906905 on Conversation_Message (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_CDB1D32D on Conversation_Topic (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_5DFA9EB6 on Conversation_TopicUser (topicId);
create index IX_3472515E on Conversation_TopicUser (userId);
