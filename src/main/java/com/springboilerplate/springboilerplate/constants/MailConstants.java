package com.springboilerplate.springboilerplate.constants;

public class MailConstants {
    public static final String PROFILE_RESET_MESSAGE_1 = "<!DOCTYPE html> " +
            "<html>" +
            "<head>" +
            "<title>Email</title>" +
            "<Meta http-equiv=Content-Type content=\"text/html; charset=utf-8\">" +
            "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\"/>" +
            "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">" +
            "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css\">" +
            "<script src=\"https://code.jquery.com/jquery-3.2.1.min.js\" integrity=\"sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=\" crossorigin=\"anonymous\"></script>" +
            "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" ></script>" +
            "</head>" +
            "<body style=\"overflow:hidden\">" +
            "<div>" +

            " <div style=\"background:#2196F3; text-align:center\">" +
            "   </div>" +

            "<div class=\"container\" >" +
            "<div class=\"row\" style=\"padding:10px;margin-top:1%;text-align:center;margin-bottom:7%\">";
    public static final String PROFILE_RESET_MESSAGE_2 =
            "<div class=\"container\">" +
                    "<p  style=\"padding:5px\">" +
                    "<span ><h4>Hi %s,</h4></span>      " +
                    "</p>" +
                    "<div class=\"col-md-6 col-md-offset-3\">" +
                    "<p style=\"color:#000000;font-size:16px\">" +
                    " Your password on Wrisx has been reset.<br/>You can login with this password " +
                    "  <br/> <br/>";
    public static final String PROFILE_RESET_MESSAGE_3 =
            "<button  style=\"font-weight: normal;margin:5px auto;display: inline-block;padding:6px 12px;margin-bottom: 0;text-align: center;font-size:14px;line-height: 1.42857143;  background-image: none;border: 1px solid transparent;border-radius: 4px;\">" +
                    "<span style=\"color:#ff3200;\">%s</span></button>" +
                    "<br/> <br/>" +
                    "Ensure to change your password immediately." +
                    "</p>";
    public static final String PROFILE_RESET_MESSAGE_4 =
            "<p  style=\"font-size:16px;color: #a94442;\"  >" +
                    "   If you didn't make this change, please notify us through any of our contacts. " +
                    "</p >" +

                    "<p style=\"color:#000000;font-size:15px\">Thank you for using Wrisx! </p>" +
                    "</div>" +

                    "</div>" +

                    "</div>" +
                    "</div>" +
                    "</body>" +
                    "</html>";
    public static final String PROFILE_RESET_SUBJECT = "Password reset";
}
