package $15_随机数;

/**
 * @author yunfeng.lu
 * @create 2017/12/4.
 */

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 */
public class TInfo {
    //private static final long serialVersionUID = 2311430593384980263L;

    /**
     * 唯一标识
     */
    private String infoId;

    /**
     * 封面图片
     */
    private String imageUrl;

    /**
     * 资讯类型
     */
    private String infoType;

    /**
     * 大标题
     */
    private String infoTitle;

    /**
     * 简介
     */
    private String tinyTitle;

    private String showType;

    private String infoUrl;

    /**
     * 作者
     */
    private String infoAuthor;

    /**
     * 发布状态：未发布、已发布、已删除
     */
    private String infoStatus;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 置顶
     */
    private String stick;

    /**
     * 关联线路
     */
    private String relateLines;

    /**
     * 关联站点
     */
    private String relateStops;

//    /**
//     * 创建时间
//     */
//    private Date createTime;
//
//    /**
//     * 修改时间
//     */
//    private Date modifyTime;

    /**
     * 访咨询内容
     */
    private String tinyContent;


    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getTinyTitle() {
        return tinyTitle;
    }

    public void setTinyTitle(String tinyTitle) {
        this.tinyTitle = tinyTitle;
    }

    public String getInfoAuthor() {
        return infoAuthor;
    }

    public void setInfoAuthor(String infoAuthor) {
        this.infoAuthor = infoAuthor;
    }

    public String getInfoStatus() {
        return infoStatus;
    }

    public void setInfoStatus(String infoStatus) {
        this.infoStatus = infoStatus;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getStick() {
        return stick;
    }

    public void setStick(String stick) {
        this.stick = stick;
    }

    public String getRelateLines() {
        return relateLines;
    }

    public void setRelateLines(String relateLines) {
        this.relateLines = relateLines;
    }

    public String getRelateStops() {
        return relateStops;
    }

    public void setRelateStops(String relateStops) {
        this.relateStops = relateStops;
    }

    public String getTinyContent() {
        return tinyContent;
    }

    public void setTinyContent(String tinyContent) {
        this.tinyContent = tinyContent;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }

}
