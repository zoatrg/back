package com.app.candm.domain;

import com.app.candm.common.enumeration.Provider;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class OauthVO {
    private Long id;
    private Provider provider;
}
