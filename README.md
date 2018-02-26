In this application is used an static URL inside data/utilities/ApiUtils :

https://andfun-weather.udacity.com/staticweather

The first is to get the JSON answer that we expect to recieve, and create the POJO classes. These POJO classes are located into the data/model folder.

Then we create a new folder for our interface called ApiService. We want to get the JSON static object from the URL so our interface will look as it:

public interface ApiService {
    @GET("staticweather")
    Observable<WeatherData> getExample();
}

Inside this folder (remote) we also create the RefrofitClient:

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

then, we create inside this class a way to take the interface with a static method called getApiService(), like it:

public class ApiUtils {

    private ApiUtils(){}

    public static final String BASE_URL = "https://andfun-weather.udacity.com/";

    public static ApiService getApiService(){
        return  RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}

then in the activity we can send our URL request with RX and retrofit in this way:

    private void getRetrofit() throws IOException {

        ApiUtils.getApiService().getExample().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeatherData>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(WeatherData weatherResponse) {
                        Log.d(TAG, "successfully "+ weatherResponse.getMessage());
                        Log.d(TAG, "successfully "+ weatherResponse.getCity().getName());

                        loadRecyclerView(weatherResponse.getList());
                    }
                });
    }

We can get the answer in weatherResponse and work with it to refresh our UI.

That is all, a simple way to implement Retrofit and RX.

Inside onBindViewHolder we pass the millis into a human redeable date using it:

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(new Date(list.get(position).getDt().longValue()*1000));

    
    
