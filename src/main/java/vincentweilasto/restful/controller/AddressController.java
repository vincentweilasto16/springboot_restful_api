package vincentweilasto.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vincentweilasto.restful.entity.User;
import vincentweilasto.restful.model.AddressResponse;
import vincentweilasto.restful.model.CreateAddressRequest;
import vincentweilasto.restful.model.UpdateAddressRequest;
import vincentweilasto.restful.model.WebResponse;
import vincentweilasto.restful.service.AddressService;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(
            path = "/api/contacts/{contactId}/addresses",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> create(User user, @RequestBody CreateAddressRequest request, @PathVariable("contactId") String contactId){
        request.setContactId(contactId);
        AddressResponse addressResponse = addressService.create(user, request);

        return WebResponse.<AddressResponse>builder()
                .data(addressResponse)
                .build();
    }

    @GetMapping(
            path = "/api/contacts/{contactId}/addresses/{addressId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> create(User user, @PathVariable("contactId") String contactId, @PathVariable("addressId") String addressId){
        AddressResponse addressResponse = addressService.get(user, contactId, addressId);

        return WebResponse.<AddressResponse>builder()
                .data(addressResponse)
                .build();
    }

    @PutMapping(
            path = "/api/contacts/{contactId}/addresses/{addressId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> update(User user, @RequestBody UpdateAddressRequest request, @PathVariable("contactId") String contactId, @PathVariable("addressId") String addressId){

        request.setContactId(contactId);
        request.setAddressId(addressId);

        AddressResponse addressResponse = addressService.update(user, request);

        return WebResponse.<AddressResponse>builder()
                .data(addressResponse)
                .build();
    }

    @DeleteMapping(
            path = "/api/contacts/{contactId}/addresses/{addressId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> remove(User user, @PathVariable("contactId") String contactId, @PathVariable("addressId") String addressId){

        addressService.remove(user, contactId, addressId);

        return WebResponse.<String>builder()
                .data("OK")
                .build();
    }

    @GetMapping(
            path = "/api/contacts/{contactId}/addresses",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<AddressResponse>> list(User user, @PathVariable("contactId") String contactId){
        List<AddressResponse> addressResponses = addressService.list(user, contactId);

        return WebResponse.<List<AddressResponse>>builder()
                .data(addressResponses)
                .build();
    }
}
