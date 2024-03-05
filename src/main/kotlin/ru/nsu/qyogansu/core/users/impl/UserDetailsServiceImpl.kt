package ru.nsu.qyogansu.core.users.impl

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return object : UserDetails {

            override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
                return hashSetOf()
            }

            override fun getPassword(): String {
                return "\$2a\$12\$68miq0B1ZWORpF1I73UDle7r/YFRh0uQPpb8PKMQ.pDeAeXu0ct9."
            }

            override fun getUsername(): String {
                return username
            }

            override fun isAccountNonExpired(): Boolean {
                return true
            }

            override fun isAccountNonLocked(): Boolean {
                return true
            }

            override fun isCredentialsNonExpired(): Boolean {
                return true
            }

            override fun isEnabled(): Boolean {
                return true
            }

        }
    }

}