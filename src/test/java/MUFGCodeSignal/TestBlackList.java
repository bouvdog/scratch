package MUFGCodeSignal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBlackList {

    @Test
    public void givenAString_whenAlsoGivenABlackList_returnNewList() {

        String original = "Today the S&P 500 had its best performance in ten years";
        String[] blacklist = {"had", "ten years"};
        String replacement = "__";
        String redactedString = Redactor.censorFromBlacklistAndReplace(original, blacklist, replacement);
        String expected = "Today the S&P 500 __ its best performance in __";
        assertEquals(expected, redactedString);
    }

    @Test
    public void replaceAllTest() {
        String s = "foobar foobar ten years foobar";
        String r = s.replaceAll("ten years", "foobar");
        System.out.println(r);
    }

    @Test
    public void applicantTest() {
        String[] applicant_ids = {"A", "B", "C", "D", "C", "E"};
        int[] credit_scores = {445, 435, 425, 475, 450, 500};
        String s = Redactor.arrangeApplicants(applicant_ids, credit_scores);
        assertEquals("BADE", s);
    }
}
