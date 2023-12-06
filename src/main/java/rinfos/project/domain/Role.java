package rinfos.project.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "Guest"),
    USER("ROLE_USER","NormalUser");

    private final String key;
    private final String title;
}
