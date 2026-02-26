package com.app.candm.domain;

import lombok.*;

@Getter @ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class TeamFileVO {
    private Long id;
    private Long teamId;
}
