package com.app.candm.domain.member;

import lombok.*;

@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
@Builder
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String password;
    private String name;
    private String phoneNumber;

}
