package be.tcla.bookinventory.mapper;

import be.tcla.bookinventory.model.Genre;
import be.tcla.bookinventory.model.Language;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumMapperTest {

    @Before
    public void init(){

    }

    @Test
    public void testMapToGenre(){

    Genre g = EnumMapper.mapToGenre(0);
        //System.out.println(g);
        // 0 == ROMAN

        assertThat(g).isEqualTo(Genre.ROMAN);
        assertThat(g.name()).isEqualToIgnoringCase("roman");

    }

    @Test(expected = RuntimeException.class)
    public void testMapToGenreWithException(){
        EnumMapper.mapToGenre(999);

    }

    @Test
    public void testMapToLanguage(){
        Language l = EnumMapper.mapToLanguage(0);
        System.out.println(l);

        assertThat(l).isEqualTo(Language.DUTCH);
        assertThat(l.getAbbreviation()).isEqualToIgnoringCase("NL");
    }

    @Test(expected = RuntimeException.class)
    public void testMapToLanguageWithException(){
        EnumMapper.mapToLanguage(999);

    }

}
