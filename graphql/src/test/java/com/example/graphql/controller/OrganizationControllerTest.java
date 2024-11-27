package com.example.graphql.controller;

import com.example.graphql.model.Organization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureGraphQlTester
class OrganizationControllerTest {
    @Autowired
    private GraphQlTester tester;

    @Test
    void addOrganization() {
        String query = "mutation { newOrganization(organization: { name: \"Test10\" }) { id } }";
        Organization organization = tester.document(query)
                .execute()
                .path("data.newOrganization")
                .entity(Organization.class)
                .get();
        assertNotNull(organization);
        assertNotNull(organization.getId());
    }

    @Test
    void findAll() {
        String query = "{ organizations { id name } }";
        List<Organization> organizations = tester.document(query)
                .execute()
                .path("data.organizations[*]")
                .entityList(Organization.class)
                .get();
        assertFalse(organizations.isEmpty());
        assertNotNull(organizations.getFirst().getId());
        assertNotNull(organizations.getFirst().getName());
    }

    @Test
    void findById() {
        String query = "{ organization(id: 1) { id name departments { id } } }";
        Organization organization = tester.document(query)
                .execute()
                .path("data.organization")
                .entity(Organization.class)
                .get();
        assertNotNull(organization);
        assertNotNull(organization.getId());
        assertFalse(organization.getDepartments().isEmpty());
    }
}