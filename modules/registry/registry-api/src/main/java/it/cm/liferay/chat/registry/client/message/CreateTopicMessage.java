package it.cm.liferay.chat.registry.client.message;

import it.cm.liferay.chat.registry.common.BaseMessage;

public class CreateTopicMessage extends BaseMessage {

	public long getUserId() {
		return userId;
	}

	public long getTargetUserId() {
		return targetUserId;
	}

	public long getTopicId() {
		return topicId;
	}

	public boolean isCreateTopic() {
		return createTopic;
	}

	public long getCompanyid() {
		return companyid;
	}

	public long getGroupId() {
		return groupId;
	}


	public void setCompanyid(long companyid) {

		this.companyid = companyid;
	}

	public void setCreateTopic(boolean createTopic) {

		this.createTopic = createTopic;
	}

	public void setGroupId(long groupId) {

		this.groupId = groupId;
	}

	public void setTargetUserId(long targetUserId) {

		this.targetUserId = targetUserId;
	}

	public void setTopicId(long topicId) {

		this.topicId = topicId;
	}

	public void setUserId(long userId) {

		this.userId = userId;
	}

	private long groupId;
	private long companyid;
	private long userId;
	private long targetUserId;
	private long topicId;
	private boolean createTopic;

}
