import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.hiquality.model.ErrorResponse;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ErrorResponseTest {

    private final ErrorResponse response = new ErrorResponse(400, "Bad request", "Invalid e-mail address provided.");

    /*
    The standard way of making assertions in Java could sometimes make us
    some troubles. Using `assert` keyword makes the code quite readable
    but the error message when the test fails gives us no clue about the
    reason of failure except of the stack trace.
     */
    @Test
    @DisplayName("The standard way of making assertions in Java")
    void theStandardWayOfMakingAssertionsInJava() {
        assert response.statusCode() == 200;
    }

    /*
    Using Hamcrest Matchers gives even more readable code - the line
    with assertions could be read almost like the English sentence.
    Apart from that the error message in the test log apart from stack
    trace contains also the actual and expected values:
    ```
    Expected: is <200>
         but: was <400>
            at ErrorResponseTest.shouldShowBasicHamcrestMatcher(ErrorResponseTest.java:39)
    ```
     */
    @Test
    @DisplayName("Should show basic Hamcrest matcher")
    void shouldShowBasicHamcrestMatcher() {
        assertThat(response.statusCode(), is(equalTo(200)));
    }

}
