//package coffeeshop.controller;
//
//import coffeeshop.entity.Orders;
//import coffeeshop.service.OrderService;
//import coffeeshop.service.PaypalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.paypal.api.payments.Links;
//import com.paypal.api.payments.Payment;
//import com.paypal.base.rest.PayPalRESTException;
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class PaypalController {
//
//    @Autowired
//    private PaypalService service;
//    
//    @Autowired
//    private OrderService orderService;
//
//    public static final String SUCCESS_URL = "/user/successfull";
//    public static final String CANCEL_URL = "/user/cancel";
//
//    @PostMapping("/pay")
//    public String payment(@ModelAttribute("order") Orders order , HttpSession session) {
//        if("cash".equalsIgnoreCase(order.getPaymentid().getType())){
//            return "redirect:/successfull";
//        }
//        try {
//            Payment payment = service.createPayment(orderService.getPriceForCheckOut(session), order.getPayment().getType(), order.getComments(), "localhost:8080/CoffeeApp" + CANCEL_URL, "localhost:8080/CoffeeApp"+SUCCESS_URL);
//            for (Links link : payment.getLinks()) {
//                if (link.getRel().equals("approval_url")) {
//                    return "redirect:" + link.getHref();
//                }
//            }
//
//        } catch (PayPalRESTException e) {
//
//            e.printStackTrace();
//        }
//        return "redirect:/";
//    }
//    
//    
//
//    @GetMapping(value = CANCEL_URL)
//    public String cancelPay() {
//        return "cancel";
//    }
//
//    @GetMapping(value = SUCCESS_URL)
//    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
//        try {
//            Payment payment = service.executePayment(paymentId, payerId);
//            System.out.println(payment.toJSON());
//            if (payment.getState().equals("approved")) {
//                return "success";
//            }
//        } catch (PayPalRESTException e) {
//            System.out.println(e.getMessage());
//        }
//        return "redirect:/";
//    }
//
//}
