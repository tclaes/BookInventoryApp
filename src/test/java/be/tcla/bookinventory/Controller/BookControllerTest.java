package be.tcla.bookinventory.Controller;

import be.tcla.bookinventory.model.Book;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ActiveProfiles("dev")
public class BookControllerTest {

    private static final String URL = "http://localhost:8085/books";
    private RestTemplate template;

    @Before
    public void init() {
        template = new RestTemplate();
    }

    @Test
    public void testFindAllBooks() throws IOException {

        ResponseEntity<java.util.List> responseEntity = template.getForEntity(URL, List.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotEmpty();

        ResponseEntity<String> jsonArray = template.getForEntity(URL, String.class);
        try {
            List<Book> allBooks = new ArrayList<>();
            JSONArray array = new JSONArray(jsonArray.getBody());
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonBook = array.getJSONObject(i);
                Book javaBook = new Book();
                javaBook.setTitle(jsonBook.getString("title"));
                javaBook.setAuthor(jsonBook.getString("author"));
                javaBook.setId(jsonBook.getInt("id"));
                allBooks.add(javaBook);
            }

            Book myFirstBook = allBooks.get(0);
            assertThat(myFirstBook.getTitle()).isEqualTo("This is it");
            assertThat(myFirstBook.getId()).isEqualTo(1);
        } catch (JSONException e) {
            e.printStackTrace();
        }


//        ObjectMapper objectMapper = new ObjectMapper();
//
//        JsonNode jsonNode = objectMapper.readTree(jsonArray.getBody());

//        assertThat(jsonNode.toString()).isEqualTo("[{\n" +
//                "    \"title\": \"This is it\",\n" +
//                "    \"publisher\": \"tom\",\n" +
//                "    \"author\": \"jos\",\n" +
//                "    \"pages\": 158,\n" +
//                "    \"ebook\": false,\n" +
//                "    \"subject\": \"ME\",\n" +
//                "    \"language\": \"DUTCH\",\n" +
//                "    \"genre\": \"ROMAN\",\n" +
//                "    \"isbn\": \"123\"\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"title\": \"This is it\",\n" +
//                "    \"publisher\": \"tom\",\n" +
//                "    \"author\": \"jos\",\n" +
//                "    \"pages\": 158,\n" +
//                "    \"ebook\": false,\n" +
//                "    \"subject\": \"ME\",\n" +
//                "    \"language\": \"DUTCH\",\n" +
//                "    \"genre\": \"ROMAN\",\n" +
//                "    \"isbn\": \"123\"\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"title\": \"This is it\",\n" +
//                "    \"publisher\": \"tom\",\n" +
//                "    \"author\": \"jos\",\n" +
//                "    \"pages\": 158,\n" +
//                "    \"ebook\": false,\n" +
//                "    \"subject\": \"ME\",\n" +
//                "    \"language\": \"DUTCH\",\n" +
//                "    \"genre\": \"ROMAN\",\n" +
//                "    \"isbn\": \"123\"\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"title\": \"This is it\",\n" +
//                "    \"publisher\": \"tom\",\n" +
//                "    \"author\": \"jef\",\n" +
//                "    \"pages\": 158,\n" +
//                "    \"ebook\": false,\n" +
//                "    \"subject\": \"ME\",\n" +
//                "    \"language\": \"DUTCH\",\n" +
//                "    \"genre\": \"ROMAN\",\n" +
//                "    \"isbn\": \"123\"\n" +
//                "  }]");

    }

    @Test
    public void testAddBook() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String jsonBook = "{\"title\": \"This is it\",\"publisher\": \"tom\",\"author\": \"jos\",\"pages\": 158,\"ebook\": false," +
                "\"subject\": \"ME\",\"language\": \"DUTCH\",\"genre\": null,\"isbn\": \"123\"}";

        HttpEntity<String> data = new HttpEntity<>(jsonBook, headers);

        ResponseEntity<Integer> response = template.postForEntity(URL, data, Integer.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(1);

    }
}
