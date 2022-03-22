# Login_Manager
Project of an sdk user, for default implementations of login/register user

## Implementation
For use, is necessary:

* **configure the feature call in a CustomApplication**
for start your app, call `LoginManager.Builder()`, passing the context application and the activity class that will be called after login

Sample:

![CustomApplication](https://user-images.githubusercontent.com/61116687/159459373-3ad97e36-6eb3-47b0-a917-f9a4cb300602.png)

obs: Your CustomApplication need be registered in AndroidManifest.

## Working
If you configured correctly the feature, when you open your app, the first activity that the user will see is the `Login Screen`

![TelaLogin](https://user-images.githubusercontent.com/61116687/159464867-a32775a2-752c-47cc-860a-cd93a559f838.png)

Clicking in register account, will be directed to `Register Screen`

![TelaRegister](https://user-images.githubusercontent.com/61116687/159465204-c46827ee-3167-48da-833c-36b6d022df1e.png)

