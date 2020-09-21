/* Parts of this file comprise externally-obtained code. */

package com.moritz.android.madassignment1.model;

import com.moritz.android.madassignment1.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CountryDataGenerator {
    public static List<Country> getCountries() {
        List<Country> countryList = new LinkedList<>();

        Country ag = new Country("Antigua and Barbuda", R.drawable.flag_ag);
        countryList.add(ag);
        ag.addQuestion(new Question("What is the capital city of Antigua and Barbuda?", new String[]{"St. John's", "Potters Village", "All Saints", "Codrington"}, 0, 10, 17, true));
        ag.addQuestion(new Question("What is the population of Antigua and Barbuda?", new String[]{"97'118", "150'254", "10'052", "502'734"}, 0, 20, 10, false));
        ag.addQuestion(new Question("What is the GDP of Antigua and Barbuda?", new String[]{"1,727,759,259 USD", "1,057,868,944 USD", "2,064,623,279 USD", "1,633,266,668 USD"}, 0, 12, 5, false));
        ag.addQuestion(new Question("What is the name of the largest city (by population) in Antigua and Barbuda?", new String[]{"St. John's", "Potters Village", "All Saints", "Codrington"}, 0, 16, 8, false));
        ag.addQuestion(new Question("What is the size of Antigua and Barbuda?", new String[]{"443", "228", "600", "480"}, 0, 18, 15, true));

        Country ai = new Country("Anguilla", R.drawable.flag_ai);
        countryList.add(ai);
        ai.addQuestion(new Question("What is the capital city of Anguilla?", new String[]{"The Valley", "Island Harbour", "Sandy Ground"}, 0, 10, 19, false));
        ai.addQuestion(new Question("What is the population of Anguilla?", new String[]{"15'094", "102'389", "5'016"}, 0, 5, 17, false));
        ai.addQuestion(new Question("What is the GDP of Anguilla?", new String[]{"108,900,000 USD", "130,542,516 USD", "69,388,604 USD", "147,331,119 USD"}, 0, 10, 14, true));
        ai.addQuestion(new Question("What is the name of the largest city (by population) in Anguilla?", new String[]{"The Valley", "Island Harbour", "Sandy Ground", "Stoney Ground"}, 0, 7, 16, false));
        ai.addQuestion(new Question("What is the size of Anguilla?", new String[]{"91", "111", "93", "129"}, 0, 11, 19, false));

        Country az = new Country("Azerbaijan", R.drawable.flag_az);
        countryList.add(az);
        az.addQuestion(new Question("What is the capital city of Azerbaijan?", new String[]{"Baku", "Ganja", "Sheki", "Sumqayit"}, 0, 20, 7, false));
        az.addQuestion(new Question("What is the population of Azerbaijan?", new String[]{"10'023'318", "44023519", "500'049"}, 0, 17, 20, true));
        az.addQuestion(new Question("What is the GDP of Azerbaijan?", new String[]{"39,207,000,000 USD", "39,442,033,329 USD", "55,573,324,798 USD", "35,304,006,879 USD"}, 0, 11, 20, false));
        az.addQuestion(new Question("What is the name of the largest city (by population) in Azerbaijan?", new String[]{"Baku", "Ganja", "Sheki", "Sumqayit"}, 0, 17, 9, false));
        az.addQuestion(new Question("What is the size of Azerbaijan?", new String[]{"86'600", "106'889", "87'885", "50'700"}, 0, 14, 20, false));

        Country bb = new Country("Barbados", R.drawable.flag_bb);
        countryList.add(bb);
        bb.addQuestion(new Question("What is the capital city of Barbados?", new String[]{"Bridgetown", "Holetown", "Speightstown", "Oistins"}, 0, 10, 8, false));
        bb.addQuestion(new Question("What is the population of Barbados?", new String[]{"287'025", "192'834", "12'093'023"}, 0, 7, 9, false));
        bb.addQuestion(new Question("What is the GDP of Barbados?", new String[]{"5,209,000,000 USD", "4,430,999,330 USD", "7,026,401,703 USD", "6,531,917,513 USD"}, 0, 16, 8, false));
        bb.addQuestion(new Question("What is the name of the largest city (by population) in Barbados?", new String[]{"Bridgetown", "Holetown", "Speightstown"}, 0, 10, 15, true));
        bb.addQuestion(new Question("What is the size of Barbados?", new String[]{"430", "333", "430", "353"}, 0, 15, 5, false));

        Country bd = new Country("Bangladesh", R.drawable.flag_bd);
        countryList.add(bd);
        bd.addQuestion(new Question("What is the capital city of Bangladesh?", new String[]{"Dhaka", "Chattogram", "Sylhet", "Khulna"}, 0, 13, 17, false));
        bd.addQuestion(new Question("What is the population of Bangladesh?", new String[]{"163'046'161", "309'572'312", "80'236"}, 0, 15, 11, false));
        bd.addQuestion(new Question("What is the GDP of Bangladesh?", new String[]{"302,571,254,131 USD", "418,338,717,877 USD", "196,510,283,393 USD", "235,563,125,418 USD"}, 0, 20, 19, false));
        bd.addQuestion(new Question("What is the name of the largest city (by population) in Bangladesh?", new String[]{"Dhaka", "Chattogram", "Sylhet", "Khulna"}, 0, 17, 12, false));
        bd.addQuestion(new Question("What is the size of Bangladesh?", new String[]{"148'460", "168'896", "196'405", "197'800"}, 0, 11, 17, true));

        Country bf = new Country("Burkina Faso", R.drawable.flag_bf);
        countryList.add(bf);
        bf.addQuestion(new Question("What is the capital city of Burkina Faso?", new String[]{"Ouagadougou", "Bobo-Dioulasso", "Banfora", "Koudougou"}, 0, 19, 5, false));
        bf.addQuestion(new Question("What is the population of Burkina Faso?", new String[]{"20'321'378", "1'028'462", "602'392"}, 0, 16, 14, true));
        bf.addQuestion(new Question("What is the GDP of Burkina Faso?", new String[]{"15,745,810,235 USD", "11,385,429,666 USD", "13,494,051,917 USD", "18,446,301,643 USD"}, 0, 11, 14, false));
        bf.addQuestion(new Question("What is the name of the largest city (by population) in Burkina Faso?", new String[]{"Fegué", "Bobo-Dioulasso", "Banfora", "Koudougou"}, 0, 19, 10, false));
        bf.addQuestion(new Question("What is the size of Burkina Faso?", new String[]{"274'200", "263'742", "163'313", "277'791"}, 0, 11, 13, false));

        Country br = new Country("Brazil", R.drawable.flag_br);
        countryList.add(br);
        br.addQuestion(new Question("What is the capital city of Brazil?", new String[]{"Brasília", "Rio De Janeiro", "Sao Paulo", "Manaus"}, 0, 15, 7, true));
        br.addQuestion(new Question("What is the population of Brazil?", new String[]{"212'559'417", "123'089'312", "424'780'281", "50'923'483"}, 0, 8, 16, false));
        br.addQuestion(new Question("What is the GDP of Brazil?", new String[]{"1,839,758,040,766 USD", "2,108,032,582,974 USD", "2,485,822,548,216 USD", "2,016,191,748,722 USD"}, 0, 18, 16, false));
        br.addQuestion(new Question("What is the name of the largest city (by population) in Brazil?", new String[]{"Lages", "Rio De Janeiro", "Sao Paulo", "Manaus"}, 0, 14, 13, false));
        br.addQuestion(new Question("What is the size of Brazil?", new String[]{"8'515'770", "9'885'905", "12'629'751", "12'361'220"}, 0, 20, 12, false));

        Country ch = new Country("Switzerland", R.drawable.flag_ch);
        countryList.add(ch);
        ch.addQuestion(new Question("What is the capital city of Switzerland?", new String[]{"Bern", "Zurich", "Geneva"}, 0, 16, 8, false));
        ch.addQuestion(new Question("What is the population of Switzerland?", new String[]{"8'574'832", "16'023'492", "43'978'539", "1'023'490"}, 0, 15, 10, false));
        ch.addQuestion(new Question("What is the GDP of Switzerland?", new String[]{"703,082,435,360 USD", "474,768,105,463 USD", "531,575,808,760 USD", "637,820,681,046 USD"}, 0, 14, 14, false));
        ch.addQuestion(new Question("What is the name of the largest city (by population) in Switzerland?", new String[]{"Zürich", "Geneva", "Lucerne"}, 0, 13, 12, false));
        ch.addQuestion(new Question("What is the size of Switzerland?", new String[]{"41'277", "30'272", "36'850", "33'726"}, 0, 18, 13, true));

        Country cz = new Country("Czech Republic", R.drawable.flag_cz);
        countryList.add(cz);
        cz.addQuestion(new Question("What is the capital city of Czech Republic?", new String[]{"Prague", "Brno", "Olomouc", "Český Krumlov"}, 0, 11, 10, false));
        cz.addQuestion(new Question("What is the population of Czech Republic?", new String[]{"10'669'709", "124'087'122", "7'348'721", ",948'201"}, 0, 19, 20, false));
        cz.addQuestion(new Question("What is the GDP of Czech Republic?", new String[]{"246,489,245,495 USD", "175,086,499,168 USD", "314,273,917,306 USD", "244,127,872,976 USD"}, 0, 17, 18, true));
        cz.addQuestion(new Question("What is the name of the largest city (by population) in Czech Republic?", new String[]{"Prague", "Brno", "Olomouc", "Český Krumlov"}, 0, 13, 7, false));
        cz.addQuestion(new Question("What is the size of Czech Republic?", new String[]{"78'867", "111'449", "64'022", "111'222"}, 0, 16, 12, false));

        Country dk = new Country("Denmark", R.drawable.flag_dk);
        countryList.add(dk);
        dk.addQuestion(new Question("What is the capital city of Denmark?", new String[]{"Copenhagen", "Aarhus", "Aalborg", "Odense"}, 0, 13, 15, false));
        dk.addQuestion(new Question("What is the population of Denmark?", new String[]{"5'818'553", "123'487'142", "971'462'311"}, 0, 9, 13, false));
        dk.addQuestion(new Question("What is the GDP of Denmark?", new String[]{"348,078,018,464 USD", "249,878,724,214 USD", "214,239,089,916 USD", "250,934,643,683 USD"}, 0, 13, 9, false));
        dk.addQuestion(new Question("What is the name of the largest city (by population) in Denmark?", new String[]{"Copenhagen", "Aarhus", "Aalborg", "Odense"}, 0, 7, 17, true));
        dk.addQuestion(new Question("What is the size of Denmark?", new String[]{"43'094", "43'755", "50'064", "29'651"}, 0, 7, 14, false));

        Country gb = new Country("United Kingdom", R.drawable.flag_gb);
        countryList.add(gb);
        gb.addQuestion(new Question("What is the capital city of United Kingdom?", new String[]{"London", "Edinburgh", "Birmingham", "Manchester"}, 0, 10, 12, false));
        gb.addQuestion(new Question("What is the population of United Kingdom?", new String[]{"66'834'405", "102'867'422", "89'743'912"}, 0, 12, 15, false));
        gb.addQuestion(new Question("What is the GDP of United Kingdom?", new String[]{"2,827,113,184,696 USD", "3,781,380,993,136 USD", "3,194,638,330,690 USD", "2,571,620,944,521 USD"}, 0, 6, 11, false));
        gb.addQuestion(new Question("What is the name of the largest city (by population) in United Kingdom?", new String[]{"London", "Edinburgh", "Birmingham", "Manchester"}, 0, 11, 7, false));
        gb.addQuestion(new Question("What is the size of United Kingdom?", new String[]{"243'610", "320'740", "276'331", "307'022"}, 0, 11, 9, true));

        Country hk = new Country("Hong Kong", R.drawable.flag_hk);
        countryList.add(hk);
        hk.addQuestion(new Question("What is the capital city of Hong Kong?", new String[]{"REMOVE THIS IT DOESN'T MAKE SENSE"}, 0, 6, 6, true));
        hk.addQuestion(new Question("What is the population of Hong Kong?", new String[]{"7'507'400", "8'901'342", "913'648"}, 0, 17, 15, false));
        hk.addQuestion(new Question("What is the GDP of Hong Kong?", new String[]{"366,029,556,273 USD", "379,835,079,007 USD", "342,061,025,844 USD", "413,882,269,172 USD"}, 0, 7, 7, false));
        hk.addQuestion(new Question("What is the name of the largest city (by population) in Hong Kong?", new String[]{"REMOVE THIS IT DOESN'T MAKE SENSE"}, 0, 7, 5, false));
        hk.addQuestion(new Question("What is the size of Hong Kong?", new String[]{"1'108", "8'808", "1'575", "1'540"}, 0, 16, 19, false));

        Country jp = new Country("Japan", R.drawable.flag_jp);
        countryList.add(jp);
        jp.addQuestion(new Question("What is the capital city of Japan?", new String[]{"Tokyo", "Osaka", "Kyoto", "Sapporo"}, 0, 20, 20, false));
        jp.addQuestion(new Question("What is the population of Japan?", new String[]{"126'264'931", "14'087'124", "89'073'151"}, 0, 6, 14, false));
        jp.addQuestion(new Question("What is the GDP of Japan?", new String[]{"5,081,769,542,380 USD", "5,725,550,296,748 USD", "3,569,317,859,902 USD", "5,933,602,053,895 USD"}, 0, 17, 11, false));
        jp.addQuestion(new Question("What is the name of the largest city (by population) in Japan?", new String[]{"Keihanshin", "Osaka", "Kyoto", "Sapporo"}, 0, 13, 9, false));
        jp.addQuestion(new Question("What is the size of Japan?", new String[]{"377'944", "281'129", "414'994", "212'806"}, 0, 7, 6, false));

        Country kr = new Country("South Korea", R.drawable.flag_kr);
        countryList.add(kr);
        kr.addQuestion(new Question("What is the capital city of South Korea?", new String[]{"Seoul", "Busan", "Daegu", "Incheon"}, 0, 15, 18, false));
        kr.addQuestion(new Question("What is the population of South Korea?", new String[]{"51'709'098", "1'498'671", "8'249'861", "912'697"}, 0, 6, 19, false));
        kr.addQuestion(new Question("What is the GDP of South Korea?", new String[]{"2,029,000,000,000 USD", "1,658,492,086,721 USD", "2,566,351,900,758 USD", "1,106,958,560,685 USD"}, 0, 16, 16, false));
        kr.addQuestion(new Question("What is the name of the largest city (by population) in South Korea?", new String[]{"Seoul", "Busan", "Daegu"}, 0, 6, 12, false));
        kr.addQuestion(new Question("What is the size of South Korea?", new String[]{"99'720", "109'203", "135'707", "56'426"}, 0, 17, 8, true));

        Country uk = new Country("Great Britain in 1850", R.drawable.flag_uk);
        countryList.add(uk);
        uk.addQuestion(new Question("What is the capital city of Great Britain in 1850?", new String[]{"London", "Liverpool", "Glasgow", "Manchester"}, 0, 17, 12, true));
        uk.addQuestion(new Question("What is the population of Great Britain in 1850?", new String[]{"27'000'000", "16'000'000", "4'000'000", "1'000'000"}, 0, 5, 16, true));
        uk.addQuestion(new Question("What is the GDP of Great Britain in 1850?", new String[]{"114,696,000,000 USD", "140,216,723,903 USD", "141,548,084,506 USD", "64,637,631,747 USD"}, 0, 15, 18, true));
        uk.addQuestion(new Question("What is the name of the largest city (by population) in Great Britain in 1850?", new String[]{"London", "Liverpool", "Glasgow", "Manchester"}, 0, 16, 6, true));
        uk.addQuestion(new Question("What is the size of Great Britain in 1850?", new String[]{"243'610", "225'600", "326'544", "300'869"}, 0, 5, 13, true));

        Country vn = new Country("Vietnam", R.drawable.flag_vn);
        countryList.add(vn);
        vn.addQuestion(new Question("What is the capital city of Vietnam?", new String[]{"Hanoi", "Ho Chi Minh City", "Da Nang", "Hue"}, 0, 19, 19, true));
        vn.addQuestion(new Question("What is the population of Vietnam?", new String[]{"96'462'106", "1'723'612", "12'489'671", "89'461'394"}, 0, 16, 8, false));
        vn.addQuestion(new Question("What is the GDP of Vietnam?", new String[]{"261,921,244,843 USD", "306,879,694,553 USD", "339,603,290,383 USD", "143,478,475,212 USD"}, 0, 5, 10, false));
        vn.addQuestion(new Question("What is the name of the largest city (by population) in Vietnam?", new String[]{"Ho Chi Minh City", "Hanoi", "Da Nang", "Hue"}, 0, 15, 16, false));
        vn.addQuestion(new Question("What is the size of Vietnam?", new String[]{"331'210", "393'980", "454'101", "194'695"}, 0, 9, 14, false));
        return countryList;
    }

    /** Randomly shuffles the choices for all questions in a list of countries, ensuring to correctly track the position of the correct choice.
     *
     * @param countryList List of countries with questions to shuffle
     * @return The shuffled list of countries (also done within countries themselves because PBR)
     */
    public static List<Country> randomiseQuestions(List<Country> countryList) {
        for (Country country : countryList) {
            for (Question question : country.getQuestions()) {
                String rightChoice = question.getChoices()[question.getCorrectChoice()];
                Collections.shuffle(Arrays.asList(question.getChoices()));

                //Move the correct choice value to the new position of the correct choice
                int ii = 0;
                for (String choice : question.getChoices()) {
                    if (choice.equals(rightChoice)) {
                        question.setCorrectChoice(ii);
                    }

                    ii++;
                }
            }
        }

        return countryList;
    }
}
