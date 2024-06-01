package org.shopping.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Vendor {
    @Id
    private Integer vendorId;
    @Column
    private String vendorName;
    @Column
    private String vendorEmail;
    @Column
    private Long vendorMobile;
    @Column
    private String vendorAddress;
    @Column
    private String vendorUserName;
    @Column
    private String vendorPassword;
    @Column
    private String vendorRegistration;
}
