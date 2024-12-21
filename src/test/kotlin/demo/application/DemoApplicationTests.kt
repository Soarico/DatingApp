package demo.application

import demo.application.client.AppClient
import org.example.demo.application.dto.About
import org.example.demo.application.dto.User
import org.example.demo.application.dto.UserCreateResponse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatusCode

@SpringBootTest
class DemoApplicationTests {
    @Autowired
//    @MockBean
    private lateinit var appClient: AppClient

    @Test
    fun makeuser() {
        val request = User(login = "helloworld", password = "echkere")
        val response = appClient.makeUser(request)
        Assertions.assertEquals(HttpStatusCode.valueOf(200), response.statusCode)
    }

    @Test
    fun editUser() {
        val regRequest = User(login = "soarico", password = "secret")
        val regResponse = appClient.makeUser(regRequest)
        Assertions.assertEquals(HttpStatusCode.valueOf(200), regResponse.statusCode)

        val formRequest = About(token = regResponse.body!!.token, id = regResponse.body!!.id, gender = true, age = 16, firstname = "Maria", lastname = "Ivanova")
        val formResponse = appClient.fillForm(formRequest, regResponse.body!!.token)
        Assertions.assertEquals(HttpStatusCode.valueOf(200), formResponse.statusCode)
    }
}
