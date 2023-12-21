package models.requestModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartRequestModel {
    private String id;
    private String cookie;
    private Integer prodId;
    private Boolean flag;
}
