# MarvelComic

Application to view the comics of the main Marvel characters, when entering the application it is possible to select between Iron Man, Captain America, Hulk or Thor. When selecting one of these, its comics are listed and when one is selected, details of the comic are displayed.

Architecture!

MVVM Architecture - Chosen because it is one of the most used architectures in the market today and also because it removes the strong coupling between each component. More importantly, in this architecture the children have no direct reference to the parent, they are only referenced by observables.


![MarvelComicDiagram](https://user-images.githubusercontent.com/2738131/216792843-2060b970-39de-4e53-9448-e9bbe301af22.png)


Hilt - Provides a standard way to do in-app DI, providing containers for each Android component in the project and managing the container lifecycle automatically. For use the Dagger was also used.

Retrofit - In addition to allowing a simple implementation and being one of the most used frameworks on the market, with OkHttp it is easy, for example, to intercept the request and change it the way you need it.

Compose - Was used because it has a great reduction of code, the Compose library is not coupled to the operating system, as with current components, it is compatible with legacy components (xml) and compose was designed in a way that we can build our interfaces with a system of small, reusable, self-contained code blocks.

AsyncImage -  is a composable that executes an image request asynchronously and renders the result. It supports the same arguments as the standard Image composable and additionally, it supports setting placeholder/error/fallback painters and onLoading/onSuccess/onError callbacks. Here's an example that loads an image with a circle crop, crossfade, and sets a placeholder.

Timber - This is a logger with a small, extensible API which provides utility on top of Android's normal Log class.

unit tests
= Improved interfaces
- Unit test

below the apk for installation:

https://drive.google.com/file/d/1YmghNF1tGdke4a-_Cz34sMlEQ58_qae2/view?usp=sharing
