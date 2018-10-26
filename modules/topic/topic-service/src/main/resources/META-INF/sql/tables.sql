create table Conversation_Message (
	uuid_ VARCHAR(75) null,
	messageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	topicId LONG,
	content VARCHAR(75) null
);

create table Conversation_Topic (
	uuid_ VARCHAR(75) null,
	topicId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Conversation_TopicUser (
	uuid_ VARCHAR(75) null,
	topicId LONG not null,
	userId LONG not null,
	primary key (topicId, userId)
);