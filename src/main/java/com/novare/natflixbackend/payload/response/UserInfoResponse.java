package com.novare.natflixbackend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoResponse {
    private Long id;
    private String username;
    private String fullName;
    private List<String> roles;
    private Integer type;

    public UserInfoResponse(Long id, String username, String fullName, List<String> roles) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.roles = roles;
    }
}
