# Anime App

An application that consumes the [Anime Api](https://docs.api.jikan.moe/#tag/top) to display
anime information and [Anime Search](https://soruly.github.io/trace.moe-api/#/docs) to search for
anime

#Building Your Application
No special requirement is needed to run your application

*Environment*

- Built on A.S Hedgehog
- JDK 17

# Design/Architectural decisions 📐

The project makes use of common android patterns in modern android codebases.

**Project Structure**
The Project has 5 main different modules with the following names and libraries used

1. **Presentation**
   Contains All the UI logic; Screens, ViewModel, Theme etc.
   - [Compose](https://developer.android.com/jetpack/compose)
   - [HiltCompose](https://developer.android.com/jetpack/compose/libraries)
   - [Google Fonts](https://developer.android.com/jetpack/compose/text/fonts)

2. **Domain**
   Contains Repository Interface and Domain Models

3. **Data**
   Contains Repository Implementation and Data Models as well as mappers from DataSources to Data
   and Data to Domain

4. **LocalDataSource**
   Contains logic to fetch current user location and cache as well as entities for the database
   - [SQLite](https://developer.android.com/training/data-storage/sqlite)
5. **RemoteDataSource**
   Contains logic to make network calls
   - [kotlinx.serialization](https://kotlinlang.org/docs/serialization.html)
   - [Ktor Client](https://ktor.io/docs/getting-started-ktor-client.html)

# Technologies 🔨

**The Application is fully written in :** [Kotlin](https://github.com/JetBrains/kotlin)

* For testing I used the following libraries

- [Junit5](https://github.com/mannodermaus/android-junit5)
- [Mockk](https://mockk.io/)
- [CoroutinesTest](https://developer.android.com/kotlin/coroutines/test)
- [Ktor Client Test](https://ktor.io/docs/http-client-testing.html)

* Tools and General setup

- [Hilt - For Dependency injection](https://developer.android.com/training/dependency-injection/hilt-android)
- [Timber - For viewing logs](https://github.com/JakeWharton/timber)
- [Ktlint](https://github.com/JLLeitschuh/ktlint-gradle)
- [Version Catalog](https://medium.com/@callmeryan/gradle-version-catalog-728111fa210f)

# Architecture

![Add MVVM diagram](/documents/mvvm.png)

- For the Presentation Layer I used MVVM for the different screens I have a Screen, Screen State and
  Screen ViewModel

![Add Clean architecture diagram](/documents/clean-architecture.png)

- I used clean architecture to Separate the different layers of the application as outlined above
