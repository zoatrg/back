package com.app.candm.common.enumeration;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum MessageStatus {
    READ("read"), UNREAD("unread");

    private String value;

    private static final Map<String, MessageStatus> MESSAGE_STATUS_MAP =
            Arrays.stream(MessageStatus.values()).collect(Collectors.toMap(MessageStatus::getValue, Function.identity()));

    MessageStatus(String value) {
        this.value = value;
    }

    public static MessageStatus getMessageStatus(String value) {
        return MESSAGE_STATUS_MAP.get(value);
    }

    public String getValue() {
        return value;
    }
}
