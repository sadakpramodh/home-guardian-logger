package com.mshomeguardian.logger.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J-\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016\u00a2\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0016H\u0014J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/mshomeguardian/logger/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "ALL_PERMISSIONS_REQUEST_CODE", "", "BACKGROUND_LOCATION_PERMISSION_REQUEST_CODE", "CALL_SMS_PERMISSION_REQUEST_CODE", "LOCATION_PERMISSION_REQUEST_CODE", "backgroundLocationPermission", "", "deviceIdText", "Landroid/widget/TextView;", "permissionsButton", "Landroid/widget/Button;", "requiredPermissions", "", "[Ljava/lang/String;", "statusText", "syncButton", "areAllPermissionsGranted", "", "checkBackgroundLocationPermission", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "requestAllPermissions", "showBackgroundLocationRationale", "showSettingsDialog", "startBackgroundServices", "updatePermissionStatus", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private final int LOCATION_PERMISSION_REQUEST_CODE = 101;
    private final int BACKGROUND_LOCATION_PERMISSION_REQUEST_CODE = 102;
    private final int CALL_SMS_PERMISSION_REQUEST_CODE = 103;
    private final int ALL_PERMISSIONS_REQUEST_CODE = 104;
    private android.widget.TextView statusText;
    private android.widget.Button permissionsButton;
    private android.widget.TextView deviceIdText;
    private android.widget.Button syncButton;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] requiredPermissions = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_CALL_LOG", "android.permission.READ_SMS", "android.permission.READ_PHONE_STATE", "android.permission.READ_CONTACTS"};
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String backgroundLocationPermission = null;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void requestAllPermissions() {
    }
    
    private final void checkBackgroundLocationPermission() {
    }
    
    private final void showBackgroundLocationRationale() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void showSettingsDialog() {
    }
    
    private final boolean areAllPermissionsGranted() {
        return false;
    }
    
    private final void updatePermissionStatus() {
    }
    
    private final void startBackgroundServices() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
}