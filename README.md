This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…


![Simulator Screenshot - iPhone 16 - 2025-06-29 at 14 50 57](https://github.com/user-attachments/assets/48de83fa-6962-4c9e-b1bf-6eff7b3ccf75)
![Simulator Screenshot - iPhone 16 - 2025-06-29 at 14 51 26](https://github.com/user-attachments/assets/f7fbe05d-159a-4517-83dc-8bacbdca23eb)
