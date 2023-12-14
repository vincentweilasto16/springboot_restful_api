package vincentweilasto.restful.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAddressRequest {

    @JsonIgnore
    @NotBlank
    private String contactId;

    @JsonIgnore
    @NotBlank
    private String addressId;

    @Size(max = 200)
    private String street;

    @Size(max = 100)
    private String city;

    @Size(max = 100)
    private String province;

    @Size(max = 100)
    @NotBlank
    private String country;

    @Size(max = 10)
    private String postalCode;
}
