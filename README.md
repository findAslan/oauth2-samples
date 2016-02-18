# oauth2-samples
oauth2 comsumer, provider, resource server samples using spring-security

<< authentication flow >>

user ---> request ---> client
    <--- redirect(/oauth/authorize) <---
user ---> /oauth/authorize -----------------> auth server
    <--- login page (&user consent) <-------
user ---> login (&approve authorization) ---> auth server
    <--- redirect url?code= <----------------
user ---> /oauth/token?code= ---------------> auth server
    <--- json{token...} <-------------------- 
user ---> request resource?token ------------> resource server (auth server)
    <---  reply -----------------------------


