package be.tcla.bookinventory.mapper;

import be.tcla.bookinventory.model.Genre;
import be.tcla.bookinventory.model.Language;

import java.util.Arrays;

public class EnumMapper {

    public static Genre mapToGenre(int genre){
        for(Genre g : Genre.values()){
            if (g.ordinal() == genre)return g;
        }

        throw new RuntimeException("Computa says No!");
    }

    public static Language mapToLanguage(int language){
//        for(Language l : Language.values()){
//            if (l.ordinal() == language)return l;
//        }
//
//        throw new RuntimeException("Computa says No!");

        return Arrays.stream(Language.values())
                .filter(l-> l.ordinal() == language)
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Does not compute"));
    }



}
