# EasyFacebook
this is facebook sdk 4.0 or later module for android, your can easy use facebook 

# install

build easyfacebook you get easyfacebook.aar in output

copy this aar in your project 

if dir name is libs 

setting gradle

repositories {
    flatDir {
        dirs 'libs' //this way we can find the .aar file in libs folder
    }
}

compile(name:'your_aar_name', ext:'aar')

# initial 

Refrence facebook developer https://developers.facebook.com/docs/android/getting-started


# sample

FacebookTool facebookTool = new FacebookTool(getActivity());

Permission[] permissions = new Permission[]{
                Permission.PUBLISH_ACTION,
        };
facebookTool.getRequestPermission(permissions);

facebookTool.getMe(bundle, new FacebookTool.Callback());

facebookTool.getComments(entityId, bundle, callback());

facebookTool.getNext(base_graphResponse, callback());

facebookTool.postComments(post_id, message, new FacebookTool.Callback() );

Bundle bundle = new Bundle();
bundle.putString("fields", "picture,full_picture,from,actions,message,link,created_time,updated_time,comments,likes");
facebookTool.getFeed(BuildConfig.FaceBookFansName(), bundle, callback());
