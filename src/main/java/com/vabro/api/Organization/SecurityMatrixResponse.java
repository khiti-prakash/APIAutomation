package com.vabro.api.Organization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecurityMatrixResponse {

    @SerializedName("canAddWorkspace")
    @Expose
    private Boolean canAddWorkspace;

    @SerializedName("canClone")
    @Expose
    private Boolean canClone;

    @SerializedName("canViewHistory")
    @Expose
    private Boolean canViewHistory;

    @SerializedName("canEdit")
    @Expose
    private Boolean canEdit;

    @SerializedName("canEditFields")
    @Expose
    private Boolean canEditFields;

    @SerializedName("canDelete")
    @Expose
    private Boolean canDelete;

    @SerializedName("canAddComment")
    @Expose
    private Boolean canAddComment;

    @SerializedName("canAddAttachment")
    @Expose
    private Boolean canAddAttachment;

    @SerializedName("canAddCommentAttachment")
    @Expose
    private Boolean canAddCommentAttachment;

    public SecurityMatrixResponse()
    {

    }

    public Boolean getCanAddWorkspace() {
        return canAddWorkspace;
    }

    public void setCanAddWorkspace(Boolean canAddWorkspace) {
        this.canAddWorkspace = canAddWorkspace;
    }

    public Boolean getCanClone() {
        return canClone;
    }

    public void setCanClone(Boolean canClone) {
        this.canClone = canClone;
    }

    public Boolean getCanViewHistory() {
        return canViewHistory;
    }

    public void setCanViewHistory(Boolean canViewHistory) {
        this.canViewHistory = canViewHistory;
    }

    public Boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Boolean getCanEditFields() {
        return canEditFields;
    }

    public void setCanEditFields(Boolean canEditFields) {
        this.canEditFields = canEditFields;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    public Boolean getCanAddComment() {
        return canAddComment;
    }

    public void setCanAddComment(Boolean canAddComment) {
        this.canAddComment = canAddComment;
    }

    public Boolean getCanAddAttachment() {
        return canAddAttachment;
    }

    public void setCanAddAttachment(Boolean canAddAttachment) {
        this.canAddAttachment = canAddAttachment;
    }

    public Boolean getCanAddCommentAttachment() {
        return canAddCommentAttachment;
    }

    public void setCanAddCommentAttachment(Boolean canAddCommentAttachment) {
        this.canAddCommentAttachment = canAddCommentAttachment;
    }
}
