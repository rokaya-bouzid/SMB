package smartbox.verification_message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartbox.verification_message.Repository.VerficationRepo;
import smartbox.verification_message.model.Verification;
import smartbox.verification_message.model.VerificationRequest;

@Service
public class VerificationService {
    @Autowired
    VerficationRepo verficationRepo;

    public void StorageVerficationMessage(VerificationRequest VerificationRequest){
        Verification vr=new Verification();
        vr.setBagNumber(VerificationRequest.getBagNumber() );

        vr.setDeviceNumber(VerificationRequest.getDeviceNumber() );
        vr.setTransactionId( VerificationRequest.getTransactionId().toString());
        vr.setContainerType(VerificationRequest.getContainerType() );
        vr.setTransmissionDate(VerificationRequest.getTransmissionDate());
        vr.setCanisterNumber(VerificationRequest.getCanisterNumber().toString() );
        vr.setCurrency(VerificationRequest.getCurrency() );
        vr.setCashCentreType(VerificationRequest.getCashCentreType() );
        vr.setCashCentreCode(VerificationRequest.getCashCentreCode());
        vr.setTotalAmount( VerificationRequest.getTotalAmount());
        vr.setTotalNotes( VerificationRequest.getTotalNotes() );
        vr.setTotalCoins( VerificationRequest.getTotalCoins());
        vr.setDenomination1( VerificationRequest.getDenomination1() );
        vr.setDenomination2( VerificationRequest.getDenomination2() );
        vr.setDenomination3( VerificationRequest.getDenomination3() );
        vr.setDenomination4(VerificationRequest.getDenomination4() );
        vr.setDenomination5( VerificationRequest.getDenomination5() );
        vr.setDenomination6( VerificationRequest.getDenomination6() );
        vr.setDenomination7( VerificationRequest.getDenomination7() );
        vr.setDenomination8( VerificationRequest.getDenomination8() );
        vr.setDenomination9( VerificationRequest.getDenomination9() );
        vr.setDenomination10( VerificationRequest.getDenomination10() );
        vr.setDenomination11( VerificationRequest.getDenomination11() );
        vr.setDenomination12( VerificationRequest.getDenomination12() );
        vr.setDenomination13(VerificationRequest.getDenomination13());
        vr.setDenomination14(VerificationRequest.getDenomination14() );
        vr.setDenomination15(VerificationRequest.getDenomination15() );
        verficationRepo.save(vr);
    }
}
