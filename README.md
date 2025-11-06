# EasyChef

EasyChef is an Android app that helps users generate meal ideas from what they already have in their pantry, with flows for pantry management and diet/cuisine preferences.


## Architecture Overview

* **Platform:** Android (Kotlin, Gradle Kotlin DSL)
* **UI:** Jetpack Compose + Material 3

  * Main screens: `Login`, `Home`, `Pantry`, `Preferences`
  * Navigation handled by `AppNavHost`
* **DI:** Hilt (`EasyChefApplication`, `SupabaseModule`)
* **Data Layer:**

  * Repositories: `AuthRepository`, `UserProfileRepository`
  * Implementations: `SupabaseAuthRepository`, `SupabaseUserProfileRepository`
  * Models: `UserProfile`, `PantryItem`, `Preferences`
* **Backend:** Supabase (Auth + Postgres)
* **Testing:** JUnit + Hilt Instrumentation (`SupabaseConnectionTest`)



## Database Schema

```sql
CREATE TABLE public.user_profiles (
  user_id uuid NOT NULL,
  user_name text,
  pantry ARRAY,
  diet text,
  cuisines ARRAY,
  updated_date timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT user_profiles_pkey PRIMARY KEY (user_id),
  CONSTRAINT user_profiles_user_id_fkey FOREIGN KEY (user_id) REFERENCES auth.users(id)
);
```


## Setup

1. **Clone the repo**

   ```bash
   git clone https://github.com/Arjun-S19/EasyChef.git
   cd EasyChef
   ```

2. **Open in Android Studio**

3. **Add Supabase credentials** to `local.properties`:

   ```properties
   SUPABASE_URL=YOUR_SUPABASE_URL
   SUPABASE_ANON_KEY=YOUR_SUPABASE_ANON_KEY
   ```

4. **Sync Gradle** (`File → Sync Project with Gradle Files`)


## Build & Run

### Android Studio

1. Select a device/emulator
2. Run the `app` configuration

### Command line

```bash
./gradlew assembleDebug
./gradlew installDebug
```


## Testing

### Local unit tests

```bash
./gradlew test
```

### Instrumentation tests

Ensure Supabase includes a `test_table`, then run:

```bash
./gradlew connectedAndroidTest
```
