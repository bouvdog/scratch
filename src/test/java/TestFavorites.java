import static org.junit.jupiter.api.Assertions.assertEquals;

import joshua.Favorites;
import org.junit.jupiter.api.Test;

public class TestFavorites {

    @Test
    public void givenInstanceOfFavorites_whenTypesArePut_thenGetRetrieves() {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "java");
        f.putFavorite(Integer.class, 123456);
        f.putFavorite(Class.class, Favorites.class);

        String favString = f.getFavorite(String.class);
        int favInt = f.getFavorite(Integer.class);
        Class<?> favClass = f.getFavorite(Class.class);

        assertEquals("Java", favString);
        assertEquals(123456, favInt);
        assertEquals(favClass, Class.class);
    }

}
