package com.lzq.one.onesdk.api;

import com.lzq.one.onesdk.api.bean.CommentPostBean;
import com.lzq.one.onesdk.api.bean.FlagBean;
import com.lzq.one.onesdk.api.bean.IdListBean;
import com.lzq.one.onesdk.api.bean.MovieBean;
import com.lzq.one.onesdk.api.bean.MovieCommentBean;
import com.lzq.one.onesdk.api.bean.MovieImgBean;
import com.lzq.one.onesdk.api.bean.MovieListBean;
import com.lzq.one.onesdk.api.bean.MoviePraisePostBean;
import com.lzq.one.onesdk.api.bean.MusicBean;
import com.lzq.one.onesdk.api.bean.MusicCommentBean;
import com.lzq.one.onesdk.api.bean.MusicListBean;
import com.lzq.one.onesdk.api.bean.OnelistBean;
import com.lzq.one.onesdk.api.bean.EssayBean;
import com.lzq.one.onesdk.api.bean.EssayCommentBean;
import com.lzq.one.onesdk.api.bean.PraisePostBean;
import com.lzq.one.onesdk.api.bean.PreMovieBean;
import com.lzq.one.onesdk.api.bean.QuestionCommentBean;
import com.lzq.one.onesdk.api.bean.QuestionInfoBean;
import com.lzq.one.onesdk.api.bean.ReadingListBean;
import com.lzq.one.onesdk.api.bean.YiYuanNewsType;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by CTWLPC on 2017/10/19.
 */

public interface OneService {

    @GET("api/onelist/idlist/?")
    //http://v3.wufazhuce.com:8000/api/onelist/idlist/?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<IdListBean> getIdList(@Query("channel") String channel,@Query("version") String version,@Query("uuid") String uuid,@Query("platform") String platform);

    @GET("api/onelist/{data}/0?")
    //http://v3.wufazhuce.com:8000/api/onelist/3528/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<OnelistBean> getOneList(@Path("data") String data,@Query("channel") String channel,@Query("version") String version,@Query("uuid") String uuid,@Query("platform") String platform);

    @GET("api/essay/{item_id}?")
    //http://v3.wufazhuce.com:8000/api/essay/1713?channel=wdj&source=summary&source_id=9261&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    //http://v3.wufazhuce.com:8000/api/essay/1701?channel=wdj&source=summary&source_id=9245&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    //http://v3.wufazhuce.com:8000/api/essay/1715?channel=wdj&source=channel_reading&source_id=9264&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<EssayBean> getEssay(@Path("item_id") String itemId, @Query("channel")String channel, @Query("source")String source, @Query("source_id")String source_id, @Query("version")String version,@Query("uuid")String uuid, @Query("platform")String platform);

    @GET("api/comment/praiseandtime/essay/{item_id}/0?")
    //http://v3.wufazhuce.com:8000/api/comment/praiseandtime/essay/1701/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<EssayCommentBean> getEssayComment(@Path("item_id") String itemId, @Query("channel")String channel,@Query("version")String version, @Query("uuid")String uuid, @Query("platform")String platform);

    @GET("api/music/detail/{item_id}?")
    //http://v3.wufazhuce.com:8000/api/music/detail/1182?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<MusicBean> getMusic(@Path("item_id") String itemId, @Query("channel")String channel, @Query("version")String version, @Query("uuid")String uuid, @Query("platform")String platform);

    @GET("api/comment/praiseandtime/music/{item_id}/0?")
    //http://v3.wufazhuce.com:8000/api/comment/praiseandtime/music/1182/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<MusicCommentBean> getMusicComment(@Path("item_id") String itemId, @Query("channel")String channel,@Query("version")String version, @Query("uuid")String uuid, @Query("platform")String platform);

    @GET("/api/movie/{item_id}/story/1/0?")
    //http://v3.wufazhuce.com:8000/api/movie/225/story/1/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<MovieBean> getMovieContent(@Path("item_id") String itemId, @Query("channel")String channel, @Query("version")String version, @Query("uuid")String uuid, @Query("platform")String platform);

    @GET("api/movie/detail/{item_id}?")
    Observable<MovieImgBean> getMovieImg(@Path("item_id") String itemId, @Query("channel")String channel, @Query("source")String source, @Query("source_id")String source_id, @Query("version")String version, @Query("uuid")String uuid, @Query("platform")String platform);

    @GET("api/comment/praiseandtime/movie/{item_id}/0?")
    //http://v3.wufazhuce.com:8000/api/movie/detail/225?channel=wdj&source=summary&source_id=9095&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<MovieCommentBean> getMovieComment(@Path("item_id") String itemId, @Query("channel")String channel, @Query("source")String source, @Query("source_id")String source_id, @Query("version")String version,@Query("uuid")String uuid, @Query("platform")String platform);

    @GET("api/channel/reading/more/0?")
    //http://v3.wufazhuce.com:8000/api/channel/reading/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<ReadingListBean> getReadingList(@Query("channel") String channel,@Query("version") String version,@Query("uuid") String uuid,@Query("platform") String platform);

    @GET("api/question/{item_id}?")
    //http://v3.wufazhuce.com:8000/api/question/1593?channel=wdj&source=channel_reading&source_id=9254&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<QuestionInfoBean> getQuestionInfo(@Path("item_id") String itemId, @Query("channel")String channel, @Query("source")String source, @Query("source_id")String source_id,@Query("version") String version, @Query("uuid")String uuid, @Query("platform")String platform);

    @GET("api/comment/praiseandtime/question/{item_id}/0?")
    //http://v3.wufazhuce.com:8000/api/comment/praiseandtime/question/1593/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<QuestionCommentBean> getQuestionInfoComment(@Path("item_id") String itemId, @Query("channel")String channel,@Query("version") String version, @Query("uuid")String uuid, @Query("platform")String platform);

    @GET("api/channel/music/more/0?")
    //http://v3.wufazhuce.com:8000/api/channel/music/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<MusicListBean> getMusicList(@Query("channel") String channel,@Query("version") String version,@Query("uuid") String uuid,@Query("platform") String platform);

    @GET("api/channel/movie/more/0?")
    //http://v3.wufazhuce.com:8000/api/channel/movie/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<MovieListBean> getMovieList(@Query("channel") String channel,@Query("version") String version,@Query("uuid") String uuid,@Query("platform") String platform);

    @GET("api/channel/movie/more/{id}?")
    //http://v3.wufazhuce.com:8000/api/movie/detail/243?channel=wdj&source=channel_movie&source_id=9240&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<PreMovieBean> getPreMovie(@Path("id") String id, @Query("channel")String channel, @Query("source")String source, @Query("source_id")String source_id,@Query("version") String version, @Query("uuid")String uuid, @Query("platform")String platform);

    @POST("api/comment/praise?")
    Observable<FlagBean> getPraiseFlag(@Body PraisePostBean user, @Field("channel") String channel,@Field("source_id") String source_id, @Field("source") String source,@Field("version") String version, @Field("uuid") String uuid, @Field("platform") String platform);

    @POST("api/praise/add?")
    Observable<FlagBean> getCommentFlag(@Body CommentPostBean user, @Field("channel") String channel, @Field("version") String version, @Field("uuid") String uuid, @Field("platform") String platform);

    @POST("api/movie/praisestory?")
    //http://v3.wufazhuce.com:8000/api/movie/praisestory?channel=update&source_id=9665&source=summary&version=4.0.7&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    Observable<FlagBean> getMoviePraiseFlag(@Body MoviePraisePostBean user, @Field("channel") String channel, @Field("source_id") String source_id, @Field("source") String source, @Field("version") String version, @Field("uuid") String uuid, @Field("platform") String platform);



    @GET("109-34?")
    Observable<YiYuanNewsType> getYiYuanNewsType(@Query("showapi_appid")String appid, @Query("showapi_sign") String sign);
}
