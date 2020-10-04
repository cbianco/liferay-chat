create index IX_6F42529 on Conversation_Message (topicId);
create index IX_29906905 on Conversation_Message (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_73C8517D on Conversation_MessageUser (read_);
create index IX_8F913A5B on Conversation_MessageUser (topicId, read_);
create index IX_D3966003 on Conversation_MessageUser (userId, read_);
create index IX_FA242295 on Conversation_MessageUser (userId, topicId, read_);

create index IX_CDB1D32D on Conversation_Topic (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_5DFA9EB6 on Conversation_TopicUser (topicId);
create index IX_3472515E on Conversation_TopicUser (userId);