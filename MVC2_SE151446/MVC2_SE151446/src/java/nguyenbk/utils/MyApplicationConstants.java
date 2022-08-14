/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenbk.utils;

/**
 *
 * @author buikh
 */
public class MyApplicationConstants {
    public class DispatchFeature {
        public static final String LOGIN_PAGE = "";
        public static final String LOGIN_CONTROLLER = "loginController";
        public static final String SEARCH_CONTROLLER = "searchController";
        public static final String DELETE_ACCOUNT_CONTROLLER = "deleteAccountServlet";
        public static final String UPDATE_ACCOUNT_CONTROLLER = "updateAccountServlet";
        public static final String COOKIES_CONTROLLER = "cookiesCheckServlet";
        public static final String LOGOUT_CONTROLLER = "logoutController";
        public static final String ADD_BOOK_CONTROLLER = "addBookController";
        public static final String REMOVE_ITEM_FROM_CART = "removeItemFromCart";
        public static final String CREATE_ACCOUNT_CONTROLLER = "createAccountController";
    }
    public class LoginFeature {
        public static final String SEARCH_PAGE = "searchPage";
        public static final String INVALID_PAGE = "invalidPage";
    }
    
    public class SearchLastNameFeature {
        public static final String STATIC_SEARCH_PAGE="searchJSPPage";
        public static final String SEARCH_PAGE = "searchPage";
    }
    
    public class DeleteFeature{
        public static final String ERROR_PAGE="bindError";
    }
    
    public class UpdateFeature{
        public static final String ERROR_PAGE="bindError";
    }
    
    public class CookiesController{
        public static final String LOGIN_PAGE = "";
        public static final String STATIC_SEARCH_PAGE="searchJSPPage";
    }
    
    public class AddToCartController{
        public static final String SHOPPING_PAGE = "shoppingPage";
        public static final String SHOW_CART_PAGE = "showCartPage";
    }
    
    public class CreateAccountController{
        public static final String CREATE_ACCOUNT_ERROR="createErrorPage";
    }
}
