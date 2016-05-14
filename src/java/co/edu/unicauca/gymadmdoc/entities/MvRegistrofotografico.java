/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "mv_registrofotografico")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MvRegistrofotografico.findAll", query = "SELECT m FROM MvRegistrofotografico m"),
   @NamedQuery(name = "MvRegistrofotografico.findByImgId", query = "SELECT m FROM MvRegistrofotografico m WHERE m.imgId = :imgId"),
   @NamedQuery(name = "MvRegistrofotografico.findByValId", query = "SELECT m FROM MvRegistrofotografico m WHERE m.valId = :valId")})
public class MvRegistrofotografico implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "IMG_ID")
   private Integer imgId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "VAL_ID")
   private int valId;
   @Lob
   @Column(name = "IMG_LAT_IZQ")
   private byte[] imgLatIzq;
   @Lob
   @Column(name = "IMG_LAT_DER")
   private byte[] imgLatDer;
   @Lob
   @Column(name = "IMG_FRONT")
   private byte[] imgFront;
   @Lob
   @Column(name = "IMG_POST")
   private byte[] imgPost;

   public MvRegistrofotografico() {
   }

   public MvRegistrofotografico(Integer imgId) {
      this.imgId = imgId;
   }

   public MvRegistrofotografico(Integer imgId, int valId) {
      this.imgId = imgId;
      this.valId = valId;
   }

   public Integer getImgId() {
      return imgId;
   }

   public void setImgId(Integer imgId) {
      this.imgId = imgId;
   }

   public int getValId() {
      return valId;
   }

   public void setValId(int valId) {
      this.valId = valId;
   }

   public byte[] getImgLatIzq() {
      return imgLatIzq;
   }

   public void setImgLatIzq(byte[] imgLatIzq) {
      this.imgLatIzq = imgLatIzq;
   }

   public byte[] getImgLatDer() {
      return imgLatDer;
   }

   public void setImgLatDer(byte[] imgLatDer) {
      this.imgLatDer = imgLatDer;
   }

   public byte[] getImgFront() {
      return imgFront;
   }

   public void setImgFront(byte[] imgFront) {
      this.imgFront = imgFront;
   }

   public byte[] getImgPost() {
      return imgPost;
   }

   public void setImgPost(byte[] imgPost) {
      this.imgPost = imgPost;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (imgId != null ? imgId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MvRegistrofotografico)) {
         return false;
      }
      MvRegistrofotografico other = (MvRegistrofotografico) object;
      if ((this.imgId == null && other.imgId != null) || (this.imgId != null && !this.imgId.equals(other.imgId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MvRegistrofotografico[ imgId=" + imgId + " ]";
   }
   
}
