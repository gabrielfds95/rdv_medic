package com.rdvmedic.rdv_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rdvmedic.rdv_api.model.Slot;
import com.rdvmedic.rdv_api.repository.SlotRepository;

import lombok.Data;

@Data
@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    public Optional<Slot> getSlot(final int id) {
        return slotRepository.findById(id);
    }

    public Iterable<Slot> getSlots() {
        return slotRepository.findAll();
    }

    public void deleteSlot(final int id) {
        slotRepository.deleteById(id);
    }

    public Slot saveSlot(Slot slot) {
        return slotRepository.save(slot);
    }
}