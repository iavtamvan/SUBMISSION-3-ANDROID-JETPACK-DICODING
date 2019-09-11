package com.iavariav.submission1.utils;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.remote.entity.MovieEmbed;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.TvShowEmbed;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;

import java.util.ArrayList;

public class DataDummy {

    private static String baseImageURL = "https://image.tmdb.org/t/p/w500";

    public static ArrayList<MovieEntity> generateDummymovie() {

        ArrayList<MovieEntity> movie = new ArrayList<>();

        movie.add(new MovieEntity("420818",
                baseImageURL + "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg",
                "The Lion King",
                "2019-07-12",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his."
        , null));


        movie.add(new MovieEntity("429617",
                baseImageURL + "/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg",
                "Spider-Man: Far from Home",
                "2019-06-28",
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent."
                , null));


        movie.add(new MovieEntity("399579",
                baseImageURL + "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "Alita: Battle Angel",
                "2019-01-31",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
                , null));


        movie.add(new MovieEntity("566555",
                baseImageURL + "/86Y6qM8zTn3PFVfCm9J98Ph7JEB.jpg",
                "Detective Conan: The Fist of Blue Sapphire",
                "2019-04-12",
                "23rd movie in the \\\"Detective Conan\\\" franchise."
                , null));


        movie.add(new MovieEntity("287947",
                baseImageURL + "/xnopI5Xtky18MPhK40cZAGAOVeV.jpg",
                "Shazam!",
                "2019-03-23",
                " boy is given the ability to become an adult superhero in times of need with a single magic word."
                , null));


        movie.add(new MovieEntity("301528",
                baseImageURL + "/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg",
                "Toy Story 4",
                "2019-06-19",
                "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \\\"Forky\\\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy."
                , null));


        movie.add(new MovieEntity("66510",
                baseImageURL + "/4F9Y9C5tQqoJbTQfJxLuDiqSOWI.jpg",
                "Madrasi",
                "2006-07-10",
                "Kasi (Arjun) comes to Mumbai to track his parents' killers. He is successful in finding the first two. In order to find the third one he joins a goon Ravi Bhai (Raj Kapoor). This Ravi Bhai is in loggerheads with his own brother, Mani Bhai (Fefsi Vijayn). Mani Bhai runs another gang and the leading goonda in this gang is Siva (Jagapati Babu). Once upon a time in some Jail, Siva and Kasi were good friends. But now they are thirsty for each other's blood. They unite finally when their loved ones are killed.They plot to kill sivas brother by killing vedhika and divert Arjun. Arjun and Vedhika die in the end."
                , null));


        movie.add(new MovieEntity("458156",
                baseImageURL + "/ziEuG1essDuWuC5lpWUaw1uXY2O.jpg",
                "John Wick: Chapter 3 – Parabellum",
                "2019-05-15",
                "Super-assassin John Wick returns with a $14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin’s guild, the High Table, John Wick is excommunicado, but the world’s most ruthless hit men and women await his every turn."
                , null));


        movie.add(new MovieEntity("299537",
                baseImageURL + "/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg",
                "Captain Marvel",
                "2019-03-06",
                "The story follows Carol Danvers as she becomes one of the universe’s most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. Set in the 1990s, Captain Marvel is an all-new adventure from a previously unseen period in the history of the Marvel Cinematic Universe."
                , null));


        movie.add(new MovieEntity("299534",
                baseImageURL + "/or06FN3Dka5tukK1e9sl16pB3iy.jpg",
                "Avengers: Endgame",
                "2019-04-24",
                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store."
                , null));


        return movie;
    }

    public static ArrayList<TvShowEntity> generateDummytv() {

        ArrayList<TvShowEntity> tv = new ArrayList<>();
        String baseImageURL = "https://image.tmdb.org/t/p/w500";

        tv.add(new TvShowEntity("11634",
                "See No Evil: The Moors Murders",
                "2006-05-14",
                baseImageURL + "/b71BaRjp9TwxUZodLGgSRIlkfL8.jpg",
                "The dramatisation of one of the most notorious killing sprees in British history.",null
        ));
        tv.add(new TvShowEntity("71446",
                "Money Heist",
                "2017-05-02",
                baseImageURL + "/MoEKaPFHABtA1xKoOteirGaHl1.jpg",
                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing."
                ,null));
        tv.add(new TvShowEntity("12609",
                "Dragon Ball",
                "1986-02-26",
                baseImageURL + "/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure."
                ,null));
        tv.add(new TvShowEntity("60735",
                "The Flash",
                "2014-10-07",
                baseImageURL + "/fki3kBlwJzFp8QohL43g9ReV455.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
                ,null));
        tv.add(new TvShowEntity("1412",
                "Arrow",
                "2012-10-10",
                baseImageURL + "/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "poiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."
                ,null));
        tv.add(new TvShowEntity("66732",
                "Stranger Things",
                "2016-07-15",
                baseImageURL + "/x2LSRK2Cm7MZhjluni1msVJ3wDF.jpg",
                "When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces, and one strange little girl."
                ,null));
        tv.add(new TvShowEntity("86034",
                "Arifureta: From Commonplace to World's Strongest",
                "2019-07-08",
                baseImageURL + "/5Z4799yZOHO6634NRekxo5aAeHK.jpg",
                "Seventeen-year-old Hajime Nagumo is your average, everyday otaku. However, his simple life of pulling all-nighters and sleeping in school is suddenly turned upside down when he, along with the rest of his class, is summoned to a fantasy world! They're treated like heroes and tasked with the duty of saving the human race from utter extinction. But what should have been any otaku's wet dream quickly turns into Hajime's nightmare. While the rest of his class are blessed with godlike powers, Hajime's job, Synergist, only has a single transmutation skill. Ridiculed and bullied by his classmates for being weak, he soon finds himself in despair. Will he be able to survive in this dangerous world of monsters and demons with only a glorified blacksmith's level of strength?"
                ,null));
        tv.add(new TvShowEntity("86816",
                "",
                "2019-01-22",
                baseImageURL + "/fMgPDXqSL4XILb0RKSXpDqc5tJ9.jpg",
                ""
                ,null));
        tv.add(new TvShowEntity("86816",
                "Crímenes que cambiaron la historia",
                "...",
                baseImageURL + "/fMgPDXqSL4XILb0RKSXpDqc5tJ9.jpg",
                ""
                ,null));
        tv.add(new TvShowEntity("63926",
                "One-Punch Man",
                "2015-10-04",
                baseImageURL + "/iE3s0lG5QVdEHOEZnoAxjmMtvne.jpg",
                "Saitama is a hero who only became a hero for fun. After three years of “special” training, though, he’s become so strong that he’s practically invincible. In fact, he’s too strong—even his mightiest opponents are taken out with a single punch, and it turns out that being devastatingly powerful is actually kind of a bore. With his passion for being a hero lost along with his hair, yet still faced with new enemies every day, how much longer can he keep it going?"
                ,null));

        return tv;
    }

    public static MovieEntity getMovie(String courseId) {
        for (int i = 0; i < generateDummymovie().size(); i++) {
            MovieEntity entity = generateDummymovie().get(i);
            if (entity.getId().equals(courseId)) {
                return entity;
            }
        }
        return null;
    }

    public static TvShowEntity getTvShow(String courseId) {
        for (int i = 0; i < generateDummytv().size(); i++) {
            TvShowEntity entity = generateDummytv().get(i);
            if (entity.getId().equals(courseId)) {
                return entity;
            }
        }
        return null;
    }

    public static MovieEmbed generateDummyCourseWithModules(MovieEntity course, boolean bookmarked) {
        MovieEmbed courseWithModule = new MovieEmbed();
        courseWithModule.mCourse = course;
        courseWithModule.mCourse.setFavorite(bookmarked);
        courseWithModule.mCourse = getMovie(course.getId());
        return courseWithModule;
    }
    public static TvShowEmbed generateDummyTvWithModules(TvShowEntity course, boolean bookmarked) {
        TvShowEmbed courseWithModule = new TvShowEmbed();
        courseWithModule.tvShowEntity = course;
        courseWithModule.tvShowEntity.setFavorite(bookmarked);
        courseWithModule.tvShowEntity = getTvShow(course.getId());
        return courseWithModule;
    }
}
