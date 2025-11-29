package bilodid.security25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/*
@author   машуля
@project   security25
@class  AccessTests
@version  1.0.0
@since 30.11.2025 - 00.16
*/


import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class AccessTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeAll() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithAnonymousUser
    public void whenAnonymThenStatusUnauthorized() throws Exception {
        mockMvc.perform(get("/api/v1/kittens"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAuthenticatedThenStatusOk() throws Exception {
        mockMvc.perform(get("/api/v1/kittens/hello/admin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAuthenticatedThenStatus403() throws Exception {
        mockMvc.perform(get("/api/v1/kittens/hello/user"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserToUserThenStatusOk() throws Exception {
        mockMvc.perform(get("/api/v1/kittens/hello/user"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserToAdminThenStatusForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/kittens/hello/admin"))
                .andExpect(status().isForbidden());
    }



    @Test
    @WithMockUser(username = "user",password = "user",roles = {"USER"})
    void whenUserToUnknownThenStatusOk() throws Exception {
        mockMvc.perform(get("/api/v1/kittens/hello/unknown"))
                .andExpect(status().isOk());
    }


    @Test
    @WithMockUser(username = "123",password = "123",roles = {"QWE"})
    void whenWrongRoleToUnknownThenStatusForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/kittens/hello/unknown"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserToStrangerThenStatusOk() throws Exception {
        mockMvc.perform(get("/api/v1/kittens/hello/stranger"))
                .andExpect(status().isOk());
    }
    @Test
    @WithAnonymousUser
    public void whenAnonymAccessesSecuredEndpointThenUnauthorized() throws Exception {
        mockMvc.perform(get("/api/v1/kittens/secured"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessesAdminEndpointThenStatusOk() throws Exception {
        mockMvc.perform(get("/api/v1/kittens/admin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserAccessesUserEndpointThenStatusOk() throws Exception {
        mockMvc.perform(get("/api/v1/kittens/user"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessesUserEndpointThenStatusOk() throws Exception {
        mockMvc.perform(get("/api/v1/kittens/user"))
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "superadmin", password = "superadmin", roles = {"SUPERADMIN"})
    public void whenSuperAdminThenStatusOk() throws Exception {
        mockMvc.perform(get("/api/v1/kittens"))
                .andExpect(status().isOk());
    }




}