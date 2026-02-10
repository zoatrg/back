package com.app.candm.domain;

import com.app.candm.audit.Period;
import com.app.candm.common.enumeration.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @ToString(callSuper = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class MemberVO extends Period {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberPhoneNumber;
    private Status memberStatus;
}
