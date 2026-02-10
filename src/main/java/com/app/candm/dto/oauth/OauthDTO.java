package com.app.candm.dto.oauth;

import com.app.candm.common.enumeration.Provider;
import com.app.candm.domain.OauthVO;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class OauthDTO {
    private Long id;
    private Provider provider;

    public OauthVO toVO() {
        return OauthVO.builder().id(id).provider(provider).build();
    }
}
