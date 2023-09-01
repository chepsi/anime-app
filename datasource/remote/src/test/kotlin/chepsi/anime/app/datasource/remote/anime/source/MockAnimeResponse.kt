package chepsi.anime.app.datasource.remote.anime.source

val mockAnimeResponse = "{\n" +
    "    \"pagination\": {\n" +
    "        \"last_visible_page\": 25404,\n" +
    "        \"has_next_page\": true,\n" +
    "        \"current_page\": 1,\n" +
    "        \"items\": {\n" +
    "            \"count\": 1,\n" +
    "            \"total\": 25404,\n" +
    "            \"per_page\": 1\n" +
    "        }\n" +
    "    },\n" +
    "    \"data\": [\n" +
    "        {\n" +
    "            \"mal_id\": 5114,\n" +
    "            \"url\": \"https://myanimelist.net/anime/5114/Fullmetal_Alchemist__Brotherhood\",\n" +
    "            \"images\": {\n" +
    "                \"jpg\": {\n" +
    "                    \"image_url\": \"https://cdn.myanimelist.net/images/anime/1208/94745.jpg\",\n" +
    "                    \"small_image_url\": \"https://cdn.myanimelist.net/images/anime/1208/94745t.jpg\",\n" +
    "                    \"large_image_url\": \"https://cdn.myanimelist.net/images/anime/1208/94745l.jpg\"\n" +
    "                },\n" +
    "                \"webp\": {\n" +
    "                    \"image_url\": \"https://cdn.myanimelist.net/images/anime/1208/94745.webp\",\n" +
    "                    \"small_image_url\": \"https://cdn.myanimelist.net/images/anime/1208/94745t.webp\",\n" +
    "                    \"large_image_url\": \"https://cdn.myanimelist.net/images/anime/1208/94745l.webp\"\n" +
    "                }\n" +
    "            },\n" +
    "            \"trailer\": {\n" +
    "                \"youtube_id\": \"--IcmZkvL0Q\",\n" +
    "                \"url\": \"https://www.youtube.com/watch?v=--IcmZkvL0Q\",\n" +
    "                \"embed_url\": \"https://www.youtube.com/embed/--IcmZkvL0Q?enablejsapi=1&wmode=opaque&autoplay=1\",\n" +
    "                \"images\": {\n" +
    "                    \"image_url\": \"https://img.youtube.com/vi/--IcmZkvL0Q/default.jpg\",\n" +
    "                    \"small_image_url\": \"https://img.youtube.com/vi/--IcmZkvL0Q/sddefault.jpg\",\n" +
    "                    \"medium_image_url\": \"https://img.youtube.com/vi/--IcmZkvL0Q/mqdefault.jpg\",\n" +
    "                    \"large_image_url\": \"https://img.youtube.com/vi/--IcmZkvL0Q/hqdefault.jpg\",\n" +
    "                    \"maximum_image_url\": \"https://img.youtube.com/vi/--IcmZkvL0Q/maxresdefault.jpg\"\n" +
    "                }\n" +
    "            },\n" +
    "            \"approved\": true,\n" +
    "            \"titles\": [\n" +
    "                {\n" +
    "                    \"type\": \"Default\",\n" +
    "                    \"title\": \"Fullmetal Alchemist: Brotherhood\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"type\": \"Synonym\",\n" +
    "                    \"title\": \"Hagane no Renkinjutsushi: Fullmetal Alchemist\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"type\": \"Synonym\",\n" +
    "                    \"title\": \"Fullmetal Alchemist (2009)\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"type\": \"Synonym\",\n" +
    "                    \"title\": \"FMA\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"type\": \"Synonym\",\n" +
    "                    \"title\": \"FMAB\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"type\": \"Japanese\",\n" +
    "                    \"title\": \"鋼の錬金術師 FULLMETAL ALCHEMIST\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"type\": \"English\",\n" +
    "                    \"title\": \"Fullmetal Alchemist: Brotherhood\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"type\": \"French\",\n" +
    "                    \"title\": \"Fullmetal Alchemist Brotherhood\"\n" +
    "                }\n" +
    "            ],\n" +
    "            \"title\": \"Fullmetal Alchemist: Brotherhood\",\n" +
    "            \"title_english\": \"Fullmetal Alchemist: Brotherhood\",\n" +
    "            \"title_japanese\": \"鋼の錬金術師 FULLMETAL ALCHEMIST\",\n" +
    "            \"title_synonyms\": [\n" +
    "                \"Hagane no Renkinjutsushi: Fullmetal Alchemist\",\n" +
    "                \"Fullmetal Alchemist (2009)\",\n" +
    "                \"FMA\",\n" +
    "                \"FMAB\"\n" +
    "            ],\n" +
    "            \"type\": \"TV\",\n" +
    "            \"source\": \"Manga\",\n" +
    "            \"episodes\": 64,\n" +
    "            \"status\": \"Finished Airing\",\n" +
    "            \"airing\": false,\n" +
    "            \"aired\": {\n" +
    "                \"from\": \"2009-04-05T00:00:00+00:00\",\n" +
    "                \"to\": \"2010-07-04T00:00:00+00:00\",\n" +
    "                \"prop\": {\n" +
    "                    \"from\": {\n" +
    "                        \"day\": 5,\n" +
    "                        \"month\": 4,\n" +
    "                        \"year\": 2009\n" +
    "                    },\n" +
    "                    \"to\": {\n" +
    "                        \"day\": 4,\n" +
    "                        \"month\": 7,\n" +
    "                        \"year\": 2010\n" +
    "                    }\n" +
    "                },\n" +
    "                \"string\": \"Apr 5, 2009 to Jul 4, 2010\"\n" +
    "            },\n" +
    "            \"duration\": \"24 min per ep\",\n" +
    "            \"rating\": \"R - 17+ (violence & profanity)\",\n" +
    "            \"score\": 9.1,\n" +
    "            \"scored_by\": 2043911,\n" +
    "            \"rank\": 1,\n" +
    "            \"popularity\": 3,\n" +
    "            \"members\": 3218225,\n" +
    "            \"favorites\": 219606,\n" +
    "            \"synopsis\": \"After a horrific alchemy experiment goes wrong in the Elric household, brothers Edward and Alphonse are left in a catastrophic new reality. Ignoring the alchemical principle banning human transmutation, the boys attempted to bring their recently deceased mother back to life. Instead, they suffered brutal personal loss: Alphonse's body disintegrated while Edward lost a leg and then sacrificed an arm to keep Alphonse's soul in the physical realm by binding it to a hulking suit of armor.\\n\\nThe brothers are rescued by their neighbor Pinako Rockbell and her granddaughter Winry. Known as a bio-mechanical engineering prodigy, Winry creates prosthetic limbs for Edward by utilizing \\\"automail,\\\" a tough, versatile metal used in robots and combat armor. After years of training, the Elric brothers set off on a quest to restore their bodies by locating the Philosopher's Stone—a powerful gem that allows an alchemist to defy the traditional laws of Equivalent Exchange.\\n\\nAs Edward becomes an infamous alchemist and gains the nickname \\\"Fullmetal,\\\" the boys' journey embroils them in a growing conspiracy that threatens the fate of the world.\\n\\n[Written by MAL Rewrite]\",\n" +
    "            \"background\": null,\n" +
    "            \"season\": \"spring\",\n" +
    "            \"year\": 2009,\n" +
    "            \"broadcast\": {\n" +
    "                \"day\": \"Sundays\",\n" +
    "                \"time\": \"17:00\",\n" +
    "                \"timezone\": \"Asia/Tokyo\",\n" +
    "                \"string\": \"Sundays at 17:00 (JST)\"\n" +
    "            },\n" +
    "            \"producers\": [\n" +
    "                {\n" +
    "                    \"mal_id\": 17,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Aniplex\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/producer/17/Aniplex\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"mal_id\": 58,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Square Enix\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/producer/58/Square_Enix\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"mal_id\": 143,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Mainichi Broadcasting System\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/producer/143/Mainichi_Broadcasting_System\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"mal_id\": 1155,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Studio Moriken\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/producer/1155/Studio_Moriken\"\n" +
    "                }\n" +
    "            ],\n" +
    "            \"licensors\": [\n" +
    "                {\n" +
    "                    \"mal_id\": 102,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Funimation\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/producer/102/Funimation\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"mal_id\": 493,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Aniplex of America\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/producer/493/Aniplex_of_America\"\n" +
    "                }\n" +
    "            ],\n" +
    "            \"studios\": [\n" +
    "                {\n" +
    "                    \"mal_id\": 4,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Bones\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/producer/4/Bones\"\n" +
    "                }\n" +
    "            ],\n" +
    "            \"genres\": [\n" +
    "                {\n" +
    "                    \"mal_id\": 1,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Action\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/genre/1/Action\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"mal_id\": 2,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Adventure\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/genre/2/Adventure\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"mal_id\": 8,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Drama\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/genre/8/Drama\"\n" +
    "                },\n" +
    "                {\n" +
    "                    \"mal_id\": 10,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Fantasy\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/genre/10/Fantasy\"\n" +
    "                }\n" +
    "            ],\n" +
    "            \"explicit_genres\": [],\n" +
    "            \"themes\": [\n" +
    "                {\n" +
    "                    \"mal_id\": 38,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Military\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/genre/38/Military\"\n" +
    "                }\n" +
    "            ],\n" +
    "            \"demographics\": [\n" +
    "                {\n" +
    "                    \"mal_id\": 27,\n" +
    "                    \"type\": \"anime\",\n" +
    "                    \"name\": \"Shounen\",\n" +
    "                    \"url\": \"https://myanimelist.net/anime/genre/27/Shounen\"\n" +
    "                }\n" +
    "            ]\n" +
    "        }\n" +
    "    ]\n" +
    "}" +
    ""
