/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ccsds.moims.mo.mal.impl.patterns;

import org.ccsds.moims.mo.mal.provider.MALProgress;
import org.ccsds.moims.mo.mal.structures.Element;
import org.ccsds.moims.mo.mal.MALException;
import org.ccsds.moims.mo.mal.MALProgressOperation;
import org.ccsds.moims.mo.mal.structures.Identifier;
import org.ccsds.moims.mo.mal.structures.StandardError;
import org.ccsds.moims.mo.mal.transport.MALMessage;
import org.ccsds.moims.mo.mal.impl.MALImpl;
import org.ccsds.moims.mo.mal.impl.MALServiceComponentImpl;

/**
 *
 * @author cooper_sf
 */
public class ProgressInteractionImpl extends InvokeInteractionImpl implements MALProgress
{
  public ProgressInteractionImpl(MALImpl impl, MALServiceComponentImpl handler, Identifier internalTransId, MALMessage msg)
  {
    super(impl, handler, internalTransId, msg);
  }

  @Override
  public void sendAcknowledgement(Element result) throws MALException
  {
    impl.getSendingInterface().returnResponse(handler, internalTransId, msg.getHeader(), MALProgressOperation.PROGRESS_ACK_STAGE, result);
  }

  @Override
  public void sendUpdate(Element update) throws MALException
  {
    impl.getSendingInterface().returnResponse(handler, internalTransId, msg.getHeader(), MALProgressOperation.PROGRESS_UPDATE_STAGE, update);
  }

  @Override
  public void sendResponse(Element result) throws MALException
  {
    impl.getSendingInterface().returnResponse(handler, internalTransId, msg.getHeader(), MALProgressOperation.PROGRESS_RESPONSE_STAGE, result);
  }

  @Override
  public void sendUpdateError(StandardError error) throws MALException
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}