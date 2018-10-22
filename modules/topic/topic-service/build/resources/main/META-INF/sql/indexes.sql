create index IX_29906905 on Conversation_Message (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6BB96CC7 on Conversation_Message (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_CDB1D32D on Conversation_Topic (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_89FF40EF on Conversation_Topic (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5DFA9EB6 on Conversation_TopicUser (topicId);
create index IX_3472515E on Conversation_TopicUser (userId);