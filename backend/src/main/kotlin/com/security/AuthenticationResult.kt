package com.security

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class AuthenticationResult(isAuthenticationSucceeded: Boolean) {
    var isAuthenticationSucceeded: Boolean = isAuthenticationSucceeded
        set(authenticationSucceeded) {
            field = isAuthenticationSucceeded
        }
}
